// Eric Demauro, Recursive descent parser.

import java.util.Scanner;

// “Sum := 5 + 3 * 2”
public class RecursiveParser {
	String line;
	String[] tokens;
	int i; 
	String token;
	
	public static boolean isNumber(String s){
		try{
			int in = Integer.parseInt(s);
		} catch(Exception e){
			return false;
		}
		
		return true;
	}
	
	public RecursiveParser() throws ParseException{
		System.out.print("Enter:");
		Scanner input = new Scanner(System.in);
		line = input.nextLine();
		tokens = line.split(" ");
		token = tokens[0];
		
		if(isNumber(token)){
			token = "number";
		}
		
		if(token.toLowerCase().equals("sum") || token.toLowerCase().equals("read")){
			token = "id";
		}
		program();
		
		System.out.println("Parse complete w/o errors.");
	}
	
	private void match(String expected) throws ParseException{
		// if string is a single character
		if(isNumber(token)){
			token = "number";
		}
		
		if(token.toLowerCase().equals("sum") || token.toLowerCase().equals("read")){
			token = "id";
		}

		if(token.toLowerCase().equals(expected.toLowerCase())){
			i++;
			if(i < tokens.length){
				token = tokens[i];
			} else {
				token = "$$";
			}
		
			
			if(isNumber(token)){
				token = "number";
			}
			
		} else {
			throw new ParseException("match: parse error. token = " + token + " expected = " + expected);
		}
	}
	
	private void program() throws ParseException{
		switch(token){
		case "id":
		case "read":
		case "write":
		case "$$":
			System.out.println("program -> stmtList $$");
			stmtList();
			match("$$");
			break;
		default:
			throw new ParseException("program: parse error. Token = " + token + ".");
		}
	}
	
	private void stmtList() throws ParseException{
		switch(token){
		case "id":
		case "read":
		case "write":
			System.out.println("stmtList -> stmt stmtList");
			stmt();
			stmtList();
			break;
		case "$$":
			System.out.println("stmtList -> e");
			break;
		default:
			throw new ParseException("stmtList: error.");
		}
	}
	
	private void stmt() throws ParseException{
		switch(token){
		case "id":
			System.out.println("stmt -> id := expr");
			match("id");
			match(":=");
			expr();
			break;
		case "read":
			System.out.println("stmt -> read id");
			match("read");
			match("id");
			break;
		case "write":
			System.out.println("stmt -> write expr");
			match("write");
			expr();
			break;
		default:
			throw new ParseException("stmt: error. token = " + token);
		}
	}
	
	private void expr() throws ParseException{
		switch(token){
		case "id":
		case "number":
		case "(":
			System.out.println("expr -> term term_tail");
			term();
			termTail();
			break;
		default:
			throw new ParseException("expr: error. token = " + token);
		}
	}
	
	private void termTail() throws ParseException{
		switch(token){
		case "+":
		case "-":
			System.out.println("termTail -> addOp term termTail");
			addOp();
			term();
			termTail();
			break;
		case ")":
		case "id":
		case "read":
		case "write":
		case "$$":
			System.out.println("termTail -> e");
			break;
		default:
			throw new ParseException("termTail: error.");
		}
	}
	
	private void term() throws ParseException{
		switch(token){
		case "id":
		case "number":
		case "(":
			System.out.println("term -> factor factorTail");
			factor();
			factorTail();
			break;
		default:
			throw new ParseException("term: error.");
		}
	}
	
	private void factorTail() throws ParseException{
		switch(token){
		case "*":
		case "/":
			System.out.println("factorTail -> multOp factor factorTail");
			multOp();
			factor();
			factorTail();
			break;
		case "+":
		case "-":
		case ")":
		case "id":
		case "read":
		case "write":
		case "$$":
			System.out.println("factorTail -> e");
			break;
		default:
			System.exit(1);	
			throw new ParseException("factorTail: error. token = " + token);
		}
	}
	
	private void factor() throws ParseException{
		switch(token){
		case "id":
			System.out.println("factor -> id");
			match("id");
			break;
		case "number":
			System.out.println("factor -> number");
			match("number");
			break;
		case "(":
			System.out.println("factor -> ( expr )");
			match("(");
			expr();
			match(")");
			break;
		default:
			throw new ParseException("factor: error.");
		}
	}
	
	private void addOp() throws ParseException{
		switch(token){
		case "+":
			System.out.println("addOp -> +");
			match("+");
			break;
		case "-":
			System.out.println("addOp -> -");
			match("-");
			break;
		default:
			throw new ParseException("addOp: error.");
		}
	}
	
	private void multOp() throws ParseException{
		switch(token){
		case "*":
			System.out.println("multOp -> *");
			match("*");
			break;
		case "/":
			System.out.println("multOp -> /");
			match("/");
			break;
		default:
			throw new ParseException("MultOp: error.");
		}
	}
	
	public static void main(String[] args) throws ParseException{
		RecursiveParser rp = new RecursiveParser();
	}
} // CalcParser

class ParseException extends Exception{
	public ParseException(String m){
		super(m);
	}
}