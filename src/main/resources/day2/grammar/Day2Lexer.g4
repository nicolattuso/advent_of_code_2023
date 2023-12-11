lexer grammar Day2Lexer;

options { caseInsensitive = true; }
@header {
package day2.gen;
}

GAME: 'game';
COLON: ':';
INTEGER: [0-9]+;
RED: 'red';
GREEN: 'green';
BLUE: 'blue';
COMMA: ',';
SEMICOLON: ';';
NEWLINE: '\r'? '\n';
WS: [ \t]+ -> skip;
