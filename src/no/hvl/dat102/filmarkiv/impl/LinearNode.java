package no.hvl.dat102.filmarkiv.impl;

public class LinearNode<T> {  //oppg 2
	
	public T data;
	public LinearNode<T> neste;
	
	
	//konstruktør
	public LinearNode(T data) {
		this.data = data;
		this.neste = null;
	}
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public LinearNode<T> getNeste() {
		return neste;
	}
	public void setNeste(LinearNode<T> neste) {
		this.neste = neste;
	}

}

//public class LinearNode<T> {
//    public T data;
//    public LinearNode<T> neste;
//
//    public LinearNode(T data) {
//        this.data = data;
//        this.neste = null;
//    }
//}
