%1.Write a predicate to generate the list of all subsets with all elements 
%of a given list. 
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

%onesol(i,i,o)
%onesol(L-list,K-int,R-list)
onesol(L,K,RL):-
    comb(L,K,RL).
allsols(L,K,R):-
    findall(RL,onesol(L,K,RL),R).
