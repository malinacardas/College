%test for 1 population

alpha=input('sign level (0,1): ');
X=[7 7 4 5 9 9 ...
   4 12 8 1 8 7 ...
   3 13 2 1 17 7 ...
   12 5 6 2 1 13 ...
   14 10 2 4 9 11 ...
   3 5 12 6 10 7];

%A)

m0=input('test value=');   %9

%H0: u=m0   (9)(>m0)
%H1: u<m0   left-tailed 

sigma=5; %case sigma is known

%tail = -1, 'left'           1, 'right'         0, 'both'
%h = 0/1 (0 -> H0 not rejected)
%p - P value
%zval - observed value of the test statistic
[h,p,ci,zval]=ztest(X,m0,sigma,alpha,'left');

if h==0
    fprintf('H0 is NOT rejected, i.e. eff IS meet \n')
else
    fprintf('H0 is rejected, i.e. eff IS NOT meet\n')
end

fprintf('Obs. value of TS is %3.5f\n',zval)
fprintf('P value %1.5f\n',p)
q1=norminv(alpha,0,1);
fprintf('Rejection region RR is (-inf, %3.5f)\n',q1)

%B)     
m0=input('test value=');   %5.5

%H0: u=m0   (5.5)(>m0)
%H1: u>m0   right-tailed 

%tail = -1, 'left'           1, 'right'         0, 'both'
%h = 0/1 (0 -> H0 not rejected)
%p - P value
%stats - contain: 1. tsttat: obs. v of TS, TS0
                % 2. df: n-1
                
[h,p,ci,stats]=ttest(X,m0,alpha,'right');

if h==0
    fprintf('H0 is NOT rejected\n')
else
    fprintf('H0 is rejected\n')
end

fprintf('Obs. value of TS is %3.5f\n',stats.tstat)
fprintf('P value %1.5f\n',p)
q1=tinv(1-alpha,stats.df);
fprintf('Rejection region RR is (%3.5f, inf)\n',q1)