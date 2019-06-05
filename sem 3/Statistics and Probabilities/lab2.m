%Binomial distr.
%n=input('Number of trials: ');
%p=input('Number of succes(0-1): ');
%PDF
%xpdf=0:n;
%ypdf=binopdf(xpdf,n,p);
%plot(xpdf,ypdf,'*');
%CDF
%xcdf=0:0.01:n;
%ycdf=binocdf(xcdf,n,p);
%plot(xcdf,ycdf,'-');

Pa1=binopdf(0,3,1/2);
Pa2=1-binopdf(1,3,1/2);

fprintf('Prob. 0 is %1.4f\n ' ,Pa1)
fprintf('Prob. 1 is %1.4f\n ' ,Pa2)

Pd1=binocdf(2,3,1/2);
fprintf('Prob. 2 is %1.4f\n', Pd1)

Pd2=binocdf(1,3,1/2);
fprintf('Prob. 2 is %1.4f\n', Pd2)

Pe1=1-binocdf(0,3,1/2);
Pe2=1-binocdf(1,3,1/2);

