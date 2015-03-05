%{
#include <stdio.h>
%}

%%
x{12345}    printf("12345 times x\n");
[0-9]*    printf("TAL: %d", atoi(yytext));
%%
