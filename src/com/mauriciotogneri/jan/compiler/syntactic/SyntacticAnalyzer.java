package com.mauriciotogneri.jan.compiler.syntactic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.kernel.Expression;
import com.mauriciotogneri.jan.kernel.Function;
import com.mauriciotogneri.jan.kernel.Program;
import com.mauriciotogneri.jan.kernel.symbols.Operator;
import com.mauriciotogneri.jan.kernel.symbols.Parameter;
import com.mauriciotogneri.jan.kernel.symbols.Primitive;
import com.mauriciotogneri.jan.kernel.symbols.operands.IntOperand;

public class SyntacticAnalyzer
{
	public Program analyze(List<Token> tokens)
	{
		// TODO
		return getSampleProgram();
	}
	
	private Program getFibonacciProgram()
	{
		// fibonacci n
		// ? (= n 0) 0
		// ? (= n 1) 1
		// + (fibonacci -- n) (fibonacci - n 2)
		
		Parameter n = new Parameter("n", 0);
		
		Function function = new Function("fibonacci");
		function.addParameter(n);
		
		Expression e1 = new Expression();
		e1.add(Primitive.getPrimitive("?"));
		e1.add(Primitive.getPrimitive("="));
		e1.add(n);
		e1.add(new IntOperand(0));
		e1.add(new IntOperand(0));
		function.addExpression(e1);
		
		Expression e2 = new Expression();
		e2.add(Primitive.getPrimitive("?"));
		e2.add(Primitive.getPrimitive("="));
		e2.add(n);
		e2.add(new IntOperand(1));
		e2.add(new IntOperand(1));
		function.addExpression(e2);
		
		Expression e3 = new Expression();
		e3.add(Primitive.getPrimitive("+"));
		e3.add(new Operator("fibonacci"));
		e3.add(Primitive.getPrimitive("--"));
		e3.add(n);
		e3.add(new Operator("fibonacci"));
		e3.add(Primitive.getPrimitive("-"));
		e3.add(n);
		e3.add(new IntOperand(2));
		function.addExpression(e3);
		
		// ---------------------------
		
		Map<String, Function> functions = new HashMap<>();
		functions.put(function.name, function);
		
		Expression entryPoint = new Expression();
		
		entryPoint.add(new Operator("fibonacci"));
		entryPoint.add(new IntOperand(12));
		
		return new Program(functions, entryPoint);
	}
	
	private Program getFactorialProgram()
	{
		// factorial n
		// ? (< n 2) 1
		// * n (factorial -- n)
		
		Parameter n = new Parameter("n", 0);
		
		Function function = new Function("factorial");
		function.addParameter(n);
		
		Expression e1 = new Expression();
		e1.add(Primitive.getPrimitive("?"));
		e1.add(Primitive.getPrimitive("<"));
		e1.add(n);
		e1.add(new IntOperand(2));
		e1.add(new IntOperand(1));
		function.addExpression(e1);
		
		Expression e2 = new Expression();
		e2.add(Primitive.getPrimitive("*"));
		e2.add(n);
		e2.add(new Operator("factorial"));
		e2.add(Primitive.getPrimitive("--"));
		e2.add(n);
		function.addExpression(e2);
		
		// ---------------------------
		
		Map<String, Function> functions = new HashMap<>();
		functions.put(function.name, function);
		
		Expression entryPoint = new Expression();
		
		entryPoint.add(new Operator("factorial"));
		entryPoint.add(new IntOperand(5));
		
		return new Program(functions, entryPoint);
	}
	
	private Program getSampleProgram()
	{
		// double n
		// * n n
		
		// double + 3 2
		
		Parameter n = new Parameter("n", 0);
		
		Function function = new Function("double");
		function.addParameter(n);
		
		Expression e = new Expression();
		e.add(Primitive.getPrimitive("*"));
		e.add(n);
		e.add(n);
		
		function.addExpression(e);
		
		// ---------------------------
		
		Map<String, Function> functions = new HashMap<>();
		functions.put(function.name, function);
		
		Expression entryPoint = new Expression();
		
		entryPoint.add(new Operator("double"));
		entryPoint.add(Primitive.getPrimitive("+"));
		entryPoint.add(new IntOperand(3));
		entryPoint.add(new IntOperand(2));
		
		return new Program(functions, entryPoint);
	}
	
	private Program getEvenProgram()
	{
		// even n
		// = 0 (% n 2)
		
		Parameter n = new Parameter("n", 0);
		
		Function function = new Function("even");
		function.addParameter(n);
		
		Expression e = new Expression();
		e.add(Primitive.getPrimitive("="));
		e.add(new IntOperand(0));
		e.add(Primitive.getPrimitive("%"));
		e.add(n);
		e.add(new IntOperand(2));
		
		function.addExpression(e);
		
		// ---------------------------
		
		Map<String, Function> functions = new HashMap<>();
		functions.put(function.name, function);
		
		Expression entryPoint = new Expression();
		
		entryPoint.add(new Operator("even"));
		entryPoint.add(new IntOperand(3));
		
		return new Program(functions, entryPoint);
	}
}