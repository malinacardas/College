%test for 2 populations

alpha=input('sign level (0,1): ');

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

%A) 
%H0: sigma1 == sigma2
%H1: sigma1 != sigma2   two tailed

[h,p,ci,stats]=vartest2(X1,X2,alpha,'both');

if h==0
    fprintf('H0 is NOT rejected\n')
else
    fprintf('H0 is rejected\n')
end

%stats:  -fstat: obs value of TS 
       % -df1: n1-1
       % -df2: n2-1
       
fprintf('Obs. value of TS is %3.5f\n',stats.fstat)
fprintf('P value %1.5f\n',p)

q1=finv(alpha/2,stats.df1,stats.df2);
q2=finv(1-alpha/2,stats.df1,stats.df2);

fprintf('Rejection region RR is (-inf,%3.5f)|_|(%3.5f, inf)\n',q1,q2)

%B)
%H0: u1=u2
%H1: u1>u2   right tailed test

%variance type: equal/unequal
[h,p,ci,stats]=ttest2(X1,X2,alpha,'both','equal');

if h==0
    fprintf('H0 is NOT rejected\n')
else
    fprintf('H0 is rejected\n')
end

%stats:  -fstat: obs value of TS 
       % -df1: n
       % -df2: n2-1
       
fprintf('Obs. value of TS is %3.5f\n',stats.fstat)
fprintf('P value %e\n',p)

q=tinv(1-alpha,stats.df);

fprintf('Rejection region RR is (%3.5f, inf)\n',q)