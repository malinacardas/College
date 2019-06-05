conf_level=input('conf_level(in(0,1))=');
alpha=1-conf_level;
x=[7 7 4 5 9 9 ...
   4 12 8 1 8 7 ...
   3 13 2 1 17 7 ...
   12 5 6 2 1 13 ...
   14 10 2 4 9 11 ...
   3 5 12 6 10 7];

sigma=5;
n=length(x);
xbar=mean(x);
q1=norminv(1-alpha/2,0,1);
q2=norminv(alpha/2,0,1);

lim1=xbar-sigma/sqrt(n)*q1;
lim2=xbar-sigma/sqrt(n)*q2;

fprintf('c.i. for the pop. mean, case sigma known, is ( %3.5f, %3.5f )\n', lim1,lim2)

%b)
s=std(x);
q1=tinv(1-alpha/2,n-1);
q2=tinv(alpha/2,n-1);

lim3=xbar-s/sqrt(n)*q1;
lim4=xbar-s/sqrt(n)*q2;

fprintf('c.i. for the pop. mean, case sigma unknown, is ( %3.5f, %3.5f )\n', lim3,lim4)

%c)
s=std(x);
svar=var(x); %s*2
q1=chi2inv(1-alpha/2,n-1);
q2=chi2inv(alpha/2,n-1);

ci1=((n-1)*s*s)/q1;
ci2=((n-1)*s*s)/q2;

fprintf('c.i. for the pop. mean, sigma^2, is ( %3.5f, %3.5f )\n', ci1,ci2)
fprintf('c.i. for the pop. mean, sigma, is ( %3.5f, %3.5f )\n', sqrt(ci1),sqrt(ci2))








