conf_level=input('conf_level(in(0,1))=');
alpha=1-conf_level;
x1=[22.4 21.7 ...
    24.5 23.4 ...
    21.6 23.3 ...
    22.4 21.6 ...
    24.8 20.0 ];
x2=[17.7 14.8 ...
    19.6 19.6 ...
    12.1 14.8 ...
    15.4 12.6 ...
    14.0 12.2 ];
n1=length(x1);
n2=length(x2);

xbar1=mean(x1);
xbar2=mean(x2);

svar1=var(x1);
svar2=var(x2);

%a)
spsq=((n1-1)*svar1+(n2-1)*svar2)/(n1+n2-2);

q1=tinv(1-alpha/2,n1+n2-2);
q2=tinv(alpha/2,n1+n2-2);

ci1=xbar1-xbar2-q1*sqrt(spsq)*sqrt(1/n1+1/n2);
ci2=xbar1-xbar2-q2*sqrt(spsq)*sqrt(1/n1+1/n2);

fprintf('c.i. for the pop. mean, case sigma known, is ( %3.5f, %3.5f )\n', ci1,ci2)

%b)

c=(svar1/n1)/(svar1/n1+svar2/n2);
oneoverc=c^2/(n-1)+(1-c)^2/(n2-1);

n=1/oneovern;

q1=tinv(1-alpha/2,n);
q2=tinv(alpha/2,n);

ci1=xbar1-xbar2-q1*sqrt(s1/n1+s2/n2);
ci2=xbar1-xbar2+q2*sqrt(s1/n1+s2/n2);











