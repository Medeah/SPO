grammar Ac;

prog
    : dcl* stmt* EOF ;

dcl
    : 'f' Id
    | 'i' Id
    ;

stmt
locals [Type type]
    : Id '=' expr          # assign
    | 'p' Id               # print
    ;

expr
locals [Type type, boolean convert2float]
    : expr op=('+'|'-') expr    # computing
    | Id                        # symref
    | Inum                      # intcon
    | Fnum                      # floatcon
    ;


Id : [a-e] | [g-h] | [j-o] | [q-z] ;
WS : [ \t\n\r]+ -> channel(HIDDEN) ;
Inum : [0-9]+ ;
Fnum : [0-9]+ '.' [0-9]+ ;