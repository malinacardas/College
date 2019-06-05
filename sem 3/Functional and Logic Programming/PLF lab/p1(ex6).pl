%6.a. Write a predicate to test if a list is a set.
%notInList(E-elem, L-list)
%flow model(i,i)
%%check if element E appears only one time in list L
%notInList(X,l1,l2,..,ln)=(false, if L=[]
%						   true, if L=[X]
%						   notInList(X,l2,...,ln), if l1\=X)
notInList(_,[]).
notInList(A,[H|T]):-
    A\=H,
    notInList(A,T).

%main function that checks if the list is a set,return true, false otherwise
%check(L-list)
%flow model(i)
%check(l1,l2,..,ln)=([], if L=[]
%					false if notInList(l1,[l2,..,ln]) is false
%					check(l2,l3,...,ln), otherwise)
%check([1,2,3,2,2,4,5,1])
check([]).
check([_]).
check([H|T]):-
    notinList(H,T),
    check(T).

%6.b. Write a predicate to remove the first three occurrences of an 
%element in a list. If the element occurs less than three times, 
%all occurrences will be removed.

%delete(L-list,E-elem,C-contor,R-result list)
%flow model(i,i,i,o)
%delete(l1,l2...ln,X,C)=([],if L=[],
%					     delete(l2,...,ln,X,C+1),if l1=X
%					     delete(l1,l2,..,ln,X,C), otherwise
%					     )
%delete([1,3,4,5,1,1,2,3,1],1,0,R).

delete([],_,_,[]).
delete([H|T],X,C,R):-
    C<3,
    H=X,
    C1 is C+1,
    delete(T,X,C1,RT),
    R=RT.
delete([H|T],X,C,R):-
    delete(T,X,C,RT),
    R=[H|RT].

