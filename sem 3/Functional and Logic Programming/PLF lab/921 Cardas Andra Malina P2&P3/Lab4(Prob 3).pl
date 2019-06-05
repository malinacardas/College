%Write a predicate to determine all decomposition of n (n given, positive),
% as sum of consecutive natural numbers.
%flow model(i,o)
%decomposition(N)=([0],N=0
%				 =(decomposition(candidate(F),
%				 				check(N,1,F),
%				 				getlist(1,F), if Sum(1,F)=N)
% candidate(V:int, R:int) :- returns a natural number less than or equal to V
% flow model: (i, o)
candidate(V, V).
candidate(V, E) :-
  V > 1,
  VE is V - 1,
  candidate(VE, E).

% getlist(F:int, L:int, R:list) :- returns a list with elements from F to L
% flow model: (i, i, o)
getlist(F, L, []) :-
  F > L.
getlist(F, F, [F]).
getlist(F, L, [F|R]) :-
  F < L,
  FP is F + 1,
  getlist(FP, L, R).

% check(N:int, F:int, L:int) :- checks if the sum of the numbers from F to L is N
% flow model: (i, i, i)
check(N, F, L) :-
  S is (L*(L+1))/2 - ((F-1)*F)/2,
  N = S.

% generate(N:int, Rez:list) :- returns a list of consecutive natural
% numbers that have the sum equal to N
% flow model: (i, o)
generate(N, Rez) :-
  candidate(N, L),
  candidate(L, F),
  check(N, F, L),
  getlist(F, L, Rez).

% solve(N:int, Rez:list) :- returns a list with all the solutions
% flow model: (i, o)
solve(N, Rez) :-
  findall(R, generate(N, R), Rez).

