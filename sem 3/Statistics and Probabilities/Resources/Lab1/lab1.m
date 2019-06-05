a=[1 0 -2; 2 1 3; 0 1 0];
b=[2 1 1; 1 0 -1; 1 1 0];
c=a-b
fprintf('Matrix C is: \n');
fprintf('%2d %2d %2d\n',c);
d=a*b;
fprintf('Matrix D is: \n');
fprintf('%2d %2d %2d\n',d);
e=a.*b;
fprintf('Matrix E is: \n');
fprintf('%2d %2d %2d\n',e);


