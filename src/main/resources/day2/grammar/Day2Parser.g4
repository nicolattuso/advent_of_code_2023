parser grammar Day2Parser;

options { tokenVocab=Day2Lexer; }
@header {
package day2.gen;
}

input : (game)+ EOF;

game: GAME INTEGER COLON sets NEWLINE?;

sets: set (SEMICOLON set)*;

set: setElement (COMMA setElement)*;

setElement: INTEGER color;

color: RED | GREEN | BLUE;
