%9.a. Insert an element on the position n in a list
%insert(L-list, E-elem,C-current position, P-position, R-resulted list)
%flow model (i,i,i,i,o)
%insert(l1,l2,..,ln,X,C,P)=([],L=[],
%							insert(l2,..,ln,X,C+1,P), if C<P

insert([],E,_,1,[E]).
insert([],_,_,P,R):-
    P>1,
    R=[].
insert([H|T],E,C,P,R):-
    P=\=C,
    C1 is C+1,
    insert(T,E,C1,P,R1),
    R=[H|R1].
insert([H|T],E,C,P,R):-
    P=:=C,
    R=[E,H|T].

%9.b. Define a predicate to determine the greatest 

% common divisor of all numbers from a list.
% cmmdc(a-integer,b-integer,r-cmmdc)
% flow model(i,i,o)
% cmmdc(a,b)=(cmmdc(a-b,b), if b<a
% 			  cmmdc(a,b-a), if a<b
% 			  a, if a=b)

cmmdc(A,B,R):-
    A=:=B,
    R is A.
cmmdc(A,B,R):-
    A=:=0,
    R is B.
cmmdc(A,B,R):-
    A<B,
    B1 is B-A,
    cmmdc(A,B1,R).
cmmdc(A,B,R):-
    A>B,
    cmmdc(B,A,R).

%computes the cmmdc of the list
%cmmdcList(L-list,X-integer, R-result)
%flow model(i,i,o)
%cmmdcList(l1,l2,...,ln,X)=([],if L=[]
%						   cmmdcList(l2,...,ln,cmmdc(l1,X)),where X is l2, then X=cmmdc(l1,X)
%						   
cmmdclist([],_,_).
cmmdclist([H|[]],X,R):-
    cmmdc(H,X,R1),
    R is R1.
cmmdclist([H|T],X,R):-
    cmmdc(H,X,R1),
    cmmdclist(T,R1,R).
