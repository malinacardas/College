%Define a predicate to produce a list of pairs (atom n) from an initial list of atoms. In this initial list atom has
%n occurrences.
%count_occ(L-list,R-resulted list)
%count_occ(l1,l2,...,ln)=[],if L=[]
%						=[[l1,1]],if L=[l1]
%						=l1 + count_occ(l2,l3,...,ln),increment(l1)
%flow model:count_occ(i,o)


increment([], E, [[E,1]]).
increment([[H,C]|T], H, [[H,C1]|T]) :-
    C1 is C + 1.
increment([[H,C]|T], E, [[H,C]|R]) :-
    H \= E,
    increment(T, E, R).

count_occ([], []).
count_occ([H|T], R) :-
    count_occ(T, Temp),
    increment(Temp, H, R).

