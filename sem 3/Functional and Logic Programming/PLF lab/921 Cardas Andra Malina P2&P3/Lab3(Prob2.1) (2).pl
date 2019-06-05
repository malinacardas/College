% Sort a list with keeping double values in resulted list
% sort(l1,l2,...,ln)=([],L=[]
%					=(l1 u sort(l2,...,ln), if l1<l2
%					=(l2 u sort(l1,l3,..,ln), if l2<l1				
%%main(L:list,S:resulted list):-returns the sorted list using bubble
%flow model(i,o)
main(List,Sorted):-
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
    X=<Y,
    bubble(Y,T,NT,Max).

%main([4,3,2,6,7],R).