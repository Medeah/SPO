grammar Hello;
//NormalClassDeclaration : ClassModifiersopt class Identifier TypeParametersopt Superopt Interfacesopt ClassBody ;
normalClassDeclaration : ClassModifier* Class Identifier typeParameters? supernon? interfaces? classBody ;

typeParameters: Lpb Identifier (Comma Identifier)* Rpb ;

supernon: Extends Identifier ;

interfaces: Implements interfaceList ;

interfaceList : Identifier (Comma Identifier)* ;

classBody : Lcur (methodInvocation Semi)* Rcur ;

// only some of them
methodInvocation: (Identifier Dot)? Identifier Lpar argumentList? Rpar ;

argumentList: Identifier (Comma Identifier)* ;

Class: 'class' ;
ClassModifier: 'Annotation' | 'public' |'protected'| 'private'| 'abstract'| 'static'| 'final'| 'strictfp' ;
Lcur: '{' ;
Rcur: '}' ;
Lpar: '(' ;
Rpar: ')' ;
Dot: '.' ;
Lpb: '<' ;
Rpb: '>' ;
Semi: ';' ;
Extends: 'extends' ;
Implements: 'implements' ;
Comma: ',' ;
Identifier : [a-zA-Z_]* [a-zA-Z0-9_]+ ;
WS : [ \t\n] -> skip ;
