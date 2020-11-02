package ProjectForm;



/**
 * <b>Elipse est la classe h�rit� de forme et repr�sente la figure �ponyme.
 * <p>
 * Une elipse est caract�ris�e par les informations suivantes :
 * <ul>
 * <li>Un premier rayon.</li>
 * <li>Un deuxieme rayon.</li>
 * </ul>
 * </p>
 */
public class Ellipse extends Forme {
	//Attributs
	protected int rayon1;
	protected int rayon2;
	
	//Constructeur
	public Ellipse() {
		
	}
	
	/**
	 * Constructeur Cercle � 5 param�tres
	 * @param x
	 * 			La coordonn�e du centre de l'elipse selon x h�rit� de Forme.
	 * @param y
	 * 			La coordonn�e du centre de l'elipse selon y h�rit� de Forme.
	 * @param couleur
	 * 			La couleur de l'elipse h�rit� de Forme.
	 * @param rayon1
	 * 			Le premier rayon de l'elipse.
	 * @param rayon2
	 * 			Le deuxieme rayon de l'elipse.
	 */
	public Ellipse(final int x, final int y, final Couleur couleur, final int rayon1, final int rayon2) {
		super(x,y, couleur);
		this.rayon1=rayon1;
		this.rayon2=rayon2;
	}
	//Methodes
	
	/**
	 * Retourne le premier rayon de l'elipse.
	 * 
	 * @return La valeur du premier rayon de l'elipse, sous forme de double.
	 */
	public double getRayon1() {
		return rayon1;
	}
	
	/**
	 * Retourne le premier rayon de l'elipse.
	 * 
	 * @return La valeur du deuxieme rayon de l'elipse, sous forme de double.
	 */
	public double getRayon2() {
		return rayon2;
	}
	
	/**
	 * Renvoi le perimetre de l'elipse.
	 * 
	 * @return La valeur du perimetre de l'elipse, sous forme de double.
	 */
	@Override
	public double perimetre() {
		System.out.println("on a");
		return 2*Math.PI*Math.sqrt(0.5*(rayon1*rayon1+rayon2*rayon2));
	}
	
	/**
	 * Renvoi le perimetre de l'aire.
	 * 
	 * @return La valeur du perimetre de l'aire, sous forme de double.
	 */
	@Override
	public double aire() {
		return Math.PI*rayon1*rayon2;
	}
	
	/**
     * Renvoi les param�tres de l'elipse.
     * 
     * @return Les param�tres de cette elipse, sous forme de cha�ne de caract�re.
     */
	@Override
	public String toString() {
		return "Ellipse " + this.couleur +" de centre: "+this.centre+ "et  [rayon1="+ rayon1 + ", rayon2=" + rayon2 + "]";
	}
	
	/**
	 * Renvoie une nouvelle Ellipse identique translat�e
	 * @param dx
	 * 			valeur de la translation selon l'axe horizontal x
	 * @param dy
	 * 			valeur de la translation selon l'axe vertical y
	 * 
	 * @return les param�tres de la nouvelle ellipse
	 */
	@Override
	public Ellipse translation(int dx, int dy) {
		int transx =(int)this.centre.getX()+dx;
		int transy =(int)this.centre.getX()+dx;
		return new Ellipse(transx, transy, couleur, rayon1, rayon2);
	}
	
	/**
	 * Renvoie une nouvelle ellipse identique pivot�e d'un angle "degree" dans le sens horaire.
	 * 
	 * @param degree
	 * 				La valeur de l'angle dont on souhaite pivoter l'ellipse 
	 * 
	 * @return les param�tres de la nouvelle ellipse
	 */
	public Ellipse rotation (double degre) throws Exception {
		double d=degre*Math.PI/180;
		double [][] Vect=new double [2][1];
		double[][] matriceRot=new double[2][2];
		matriceRot[0][0]=Math.cos(d);
		matriceRot[0][1]=Math.sin(d);
		matriceRot[1][0]=-matriceRot[0][1];
		matriceRot[1][1]=matriceRot[0][0];
		double x=this.centre.getX();
		double y=this.centre.getY();
		Vect[0][0]=x;
		Vect[1][0]=y;
		Point pointNew =new Point(multiplier(matriceRot, Vect)[0][0],multiplier(matriceRot, Vect)[1][0]);
		return new Ellipse((int)pointNew.getX(), (int)pointNew.getY(),this.couleur, this.rayon1, this.rayon2);
		
	}
	
	/**
	 * Renvoie l'homothetie de l'ellipse.
	 * 
	 * @param k
	 * 			le facteur de l'homothetie
	 * 
	 * @return les param�tres de la nouvelle ellipse
	 */
	public Ellipse homothetie(int k) {
		return new Ellipse((int)this.centre.getX()*k, (int)this.centre.getY()*k, couleur, rayon1*k, rayon2*k);
	}


}
