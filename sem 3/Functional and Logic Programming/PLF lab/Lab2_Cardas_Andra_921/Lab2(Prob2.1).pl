%delete all the occurences of an element in a list
%delete_all(E-integer, L-list, R-resulted list)
%delete_all(elem,l1,l2,...,ln)=[],if L=[]
%							  =[],if L=[elem]
%							  =l1 + delete_all(elem,l2,...,ln),if elem \= l1
%flow model: delete_all(i,i,o)
delete_all(_,[],[]).
delete_all(E,[H|T],R):-
    H=:=E,
    delete_all(E,T,RT),
    R=RT.
delete_all(E,[H|T],R):-
           delete_all(E,T,RT),
           R=[H|RT].
           
%delete_all(2,[1,2,3,4,2,5,3,2],R)