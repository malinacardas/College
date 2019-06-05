%Generate the list of all arrangements of K elements of a given list.

%minsert(L-list,E-int,R-result)
%minsert(i,i,o)
%minsert(l1,l2..,ln,E)=([E],if L=[]
%						l1 u insert(l2,..,ln,E))
minsert([],E,[E]).
minsert([H|T],E,[E,H|T]).
minsert([H|T],E,[H|TR]):-
    minsert(T,E,TR).

%perm(L-list, R-list)
%perm(i,o)
%perm(l1,l2,...,ln)=([],L=[]
%					perm(insert(l2,...,ln),l1)))
perm([],[]).
perm([H|T],R):-
    perm(T,RT),
    minsert(RT,H,R).

%comb(L-list, K-int,R-list)
%comb(i,i,o)
%comb(l1,l2..,ln,k)=([],L=[]
%					l1 u comb(l2,...,ln,k-1),k>0
%					comb(l2,...,ln,k),k>0)
comb(_,0,[]).
comb([H|T],K,[H|TR]):-
    K>0,
    K1 is K-1,
    comb(T,K1,TR).
comb([_|T],K,R):-
    K>0,
    comb(T,K,R).

%arr(L-list,K-int,R-list)
%arr(i,i,o)
arr(L,K,R):-
    comb(L,K,R1),
    perm(R1,R).

%onesol(i,i,o)
%onesol(L-list,K-int,R-list)
onesol(L,K,RL):-
    arr(L,K,RL).
allsols(L,K,R):-
    findall(RL,onesol(L,K,RL),R).