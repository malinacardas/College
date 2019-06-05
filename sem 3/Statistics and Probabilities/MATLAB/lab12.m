x=0:0.01:3;
y=x.^4/10;
z=x.*sin(x);
t=cos(x);
plot(x,y,'b*:',x,z,'g+-',x,t,'ks:');

