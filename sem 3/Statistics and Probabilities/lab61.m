%test for 1 
alpha=input('sign.level(in(0,1)=');
%a)
m0=input('test value='); %9
%h0:miu=m0 (9) (m0>0)
%h1:miu<m0 left-tailed
%sample data:
x=[7 7 4 5 9 9 ...
   4 12 8 1 8 7 ...
   3 13 2 1 17 7 ...
   12 5 6 2 1 13 ...
   14 10 2 4 9 11 ...
   3 5 12 6 10 7]; 
sigma=5; %known
[h,p,ci,zval]=ztest(x,m0,sigma,0.05,'left');
if h==0
        fprintf('H0 is not rejected,i.e..\n')
else
        fprintf('H0 is rej \n')
end
fprintf('Observe value of the test statistic %3.5f \n', zval)
fprintf('Pvalue is %1.5f \n', p)

q1=norminv(alpha,0,1);
fprintf('Rejection region RR is (-inf, %3.5f ) \n' , q1)

%b)
alpha=input('sign.level(in(0,1)=');
m0=input('test value='); %5.5
x=[7 7 4 5 9 9 ...
   4 12 8 1 8 7 ...
   3 13 2 1 17 7 ...
   12 5 6 2 1 13 ...
   14 10 2 4 9 11 ...
   3 5 12 6 10 7]; 
[h,p,ci,stats]=ttest(x,m0,alpha,'right');
if h==0
        fprintf('H0 is not rejected,i.e..\n')
else
        fprintf('H0 is rej \n')
end
fprintf('Observe value of the test statistic %3.5f \n',stats.tstat)
fprintf('Pvalue is %1.5f \n', p)

q2=tinv(1-alpha,stats.df);
fprintf('Rejection region RR is (%3.5f ,inf) \n' , q2)




