%Part B, problem 2

conf_level=input('conf_level: ');
alpha=1-conf_level;

X1=[22.4 21.7 ...
    24.5 23.4 ...
    21.6 23.3 ...
    22.4 21.6 ...
    24.8 20.0];
X2=[17.7 14.8 ...
    19.6 19.6 ...
    12.1 14.8 ...
    15.4 12.6 ...
    14.0 12.2];

n1=length(X1);
n2=length(X2);

xbar1=mean(X1);
xbar2=mean(X2);

svar1=var(X1);
svar2=var(X2);

%a) sigma1=sigma2

spsq=((n1-1)*svar1+(n2-1)*svar2)/(n1+n2-2);

q1=tinv(1-alpha/2,n1+n2-2);
q2=tinv(alpha/2,n1+n2-2);

lim1=xbar1-xbar2-q1*sqrt(spsq)*sqrt(1/n1+1/n2);
lim2=xbar1-xbar2-q2*sqrt(spsq)*sqrt(1/n1+1/n2);

fprintf('c.i. for the diff of pop means, case sigma1=sigma2 is (%3.5f,%3.5f)\n',lim1,lim2)

%b) sigma1!=sigma2

c=(svar1/n1)/(svar1/n1+svar2/n2);

oneovern=c^2/(n1-1)+(1-c)^2/(n2-1);
n=1/oneovern;

q1=tinv(1-alpha/2,n);
q2=tinv(alpha/2,n);

lim1=xbar1-xbar2-q1*sqrt(svar1/n1+svar2/n2);
lim2=xbar1-xbar2-q2*sqrt(svar1/n1+svar2/n2);

fprintf('c.i. for the diff of pop means, case sigma1!=sigma2 is (%3.5f,%3.5f)\n',lim1,lim2)

