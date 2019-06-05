% 1. For a heterogeneous list, formed from integer numbers and list of numbers, 
% write a predicate to sort every
%sublist, removing the doubles.
%% main(l1,l2,...,ln)=([],L=[]
%					=(l1 u main(l2,...,ln), if l1<l2
%					=(l2 u main(l1,l3,..,ln), if l2<l1)	

%main2(L:list,S:resulted list):-returns the sorted list using bubble
%flow model(i,o)
main2(List,Sorted):-
    bubblesort(List,[],Sorted).

%bubblesort:-sorts a list by swaping pairs of numbers
%flow model(i,i,o)
bubblesort([],Acc,Acc).
bubblesort([H|T],Acc,Sorted):-
    bubble(H,T,NT,Max),
    bubblesort(NT,[Max|Acc],Sorted).
 
%bubble:-swap two elements by their value
bubble(X,[],[],X).
bubble(X,[Y|T],[Y|NT],Max):-
    X>Y,
    bubble(X,T,NT,Max).
bubble(X,[Y|T],[X|NT],Max):-
    X<Y,
    bubble(Y,T,NT,Max).

%main(L-list,R-resulted list):-sort the heteregenous list by sorting the atoms, the numbers and the sublists
%flow model(i,o)
main([],[]).
main([H|T],[H|LR]):-
    number(H),
    main(T,LR).
main([H|T],[H|LR]):-
    atom(H),
    main(T,LR).
main([H|T],[H1|LR]):-
    is_list(H),
    main2(H,H1),
    main(T,LR).
