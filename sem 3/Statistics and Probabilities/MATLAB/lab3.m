miu=input('miu in R: ');
sigma=input('sigma >0 :');

Pa1=normcdf(0,miu,sigma);
Pa2=1-Pa1;

fprintf('Prob. 0 is %1.4f\n ' ,Pa1)
fprintf('Prob. 1 is %1.4f\n ' ,Pa2)

Pb1=normcdf(1,miu,sigma)-normcdf(-1,miu,sigma);
Pb2=1-Pb1;

fprintf('Prob. 2 is %1.4f\n ' ,Pb1)
fprintf('Prob. 3 is %1.4f\n ' ,Pb2)

alpha=input('alpha=');
Pc=norminv(alpha,miu,sigma);


