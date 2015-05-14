package com.mauriciotogneri.jan.kernel.symbols.primitives.logic.operations;

import com.mauriciotogneri.jan.kernel.symbols.operands.BoolOperand;
import com.mauriciotogneri.jan.kernel.symbols.primitives.logic.base.PrimitiveLogicBinaryBoolean;

public class PrimitiveOr extends PrimitiveLogicBinaryBoolean
{
	public static final String SYMBOL = "|";
	
	public PrimitiveOr()
	{
		super(SYMBOL);
	}
	
	@Override
	protected BoolOperand apply(boolean operand1, boolean operand2)
	{
		return new BoolOperand(operand1 || operand2);
	}
}