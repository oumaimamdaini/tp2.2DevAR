package connectioOperationact2;



import java.io.Serializable;



public class Operation implements Serializable {

	private int op1,op2,resultat;

	private char operation;

	public int getOp1() {

		return op1;

	}

	public void setOp1(int op1) {

		this.op1 = op1;

	}

	public int getOp2() {

		return op2;

	}

	public Operation(int op1, int op2,char operation) {

		this.op1 = op1;

		this.op2 = op2;

		this.operation = operation;

	}

	public void setOp2(int op2) {

		this.op2 = op2;

	}

	public int getResultat() {

		return resultat;

	}

	public void setResultat(int resultat) {

		this.resultat = resultat;

	}

	public char getOperation() {

		return operation;

	}

	public void setOperation(char operation) {

		this.operation = operation;

	}



  



}