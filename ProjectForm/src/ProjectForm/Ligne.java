package ProjectForm;

import java.util.ArrayList;

/**
 * <b>Ligne est la classe représentant la forme géométrique éponyme et hérite de la classe Forme.
 * <p>
 * Une ligne est caractérisé par les informations suivantes :
 * <ul>
 * <li>une coordonnée d'une extremite selon x</li>
 * <li>une coordonnée d'une extremite selon y</li>
 * <li>une coordonnée de l'autre extremite selon x</li>
 * <li>une coordonnée de l'autre extremite selon y</li>
 * <li>une epaisseur</li>
 * </ul>
 * </p>
 */
public class Ligne extends Forme {
	//Attributs
	private Point extremite1;
	private Point extremite2;
	private int epaisseur;
	
	//Constructeur
	/**
	 * Constructeur Ligne à 6 paramètres
	 * @param x
	 * 			La coordonnée du centre selon x.
	 * @param y
	 * 			La coordonnée du centre selon y.
	 * @param couleur
	 * 			La couleur de la ligne.
	 * @param p1
	 * 			La première extremite de la ligne.
	 * @param p2
	 *  		La deuxieme extremite de la ligne.
	 * @param epaisseur
	 * 			L'epaisseur de la ligne. 
	 */
	public Ligne(int x, int y,Couleur couleur,Point p1, Point p2 ,int epaisseur) {
		super(x,y,couleur);
		this.extremite1=p1;
		this.extremite2=p2;
		this.epaisseur=epaisseur;
	}
	//Methode
	
	/**
	 * Renvoi le perimetre de la ligne.
	 * 
	 * @return La valeur du perimetre de la ligne, sous forme de double.
	 */
	public double perimetre() {
		System.out.print("La longueur de la " + this +" est : ");
		return this.extremite1.distance(this.extremite2)*2+2*this.epaisseur;
	}
	
	/**
	 * Renvoi l'aire de la ligne.
	 * 
	 * @return La valeur de l'aire de la ligne, sous forme de double.
	 */
	public double aire() {
		System.out.print("L'aire de ce segment est: ");
		return this.extremite1.distance(this.extremite2)*this.epaisseur;
	}
	
	/**
	 * Renvoi les parametres de la ligne.
	 * 
	 * @return Les parametres de la ligne, sous forme de chaîne de caractère.
	 */
	@Override
	public String toString() {
		return "Ligne " +this.couleur+ " ["+this.extremite1 + ", " + this.extremite2+"] d'epaisseur "+this.epaisseur;
	}
	/**
	 * Renvoie une nouvelle ligne identique translatée
	 * 
	 * @param dx
	 * 			valeur de la translation selon l'axe horizontal x
	 * @param dy
	 * 			valeur de la translation selon l'axe vertical y
	 * 
	 * @return les paramètres de la nouvelle ligne
	 */
	@Override
	public Ligne translation(int dx, int dy) {
		return new Ligne((int)centre.getX()+dx, (int)centre.getY()+dy, this.couleur, new Point(this.extremite1.getX()+dx,this.extremite1.getY()+dy), new Point(this.extremite2.getX()+dx,this.extremite2.getY()), this.epaisseur);
	}
	
	/**
	 * Renvoie une nouvelle ligne identique pivoté d'un angle "degree" dans le sens horaire.
	 * 
	 * @param degree
	 * 				La valeur de l'angle dont on souhaite pivoter la ligne 
	 * 
	 * @return les paramètres de la nouvelle ligne
	 */
	public Ligne rotation (double degre) throws Exception {
		ArrayList<Point> extremites=new ArrayList<Point>();
		extremites.add(this.extremite1);
		extremites.add(this.extremite2);
		double d=degre*Math.PI/180;
		double [][] Vect=new double [2][1];
		double[][] matriceRot=new double[2][2];
		ArrayList<Point> points=new ArrayList<Point>();
		matriceRot[0][0]=Math.cos(d);
		matriceRot[0][1]=Math.sin(d);
		matriceRot[1][0]=-matriceRot[0][1];
		matriceRot[1][1]=matriceRot[0][0];
		for (int i=0; i<extremites.size();i++) {
		double x=extremites.get(i).getX();
		double y=extremites.get(i).getY();
		Vect[0][0]=x;
		Vect[1][0]=y;
		Point pointNew =new Point(multiplier(matriceRot, Vect)[0][0],multiplier(matriceRot, Vect)[1][0]);
		points.add(pointNew);
		}
		return new Ligne((int)this.centre.getX(), (int)this.centre.getY(), this.couleur, points.get(0), points.get(1), this.epaisseur);
		
	}
	
	/**
	 * Renvoie l'homothetie de la ligne.
	 * 
	 * @param k
	 * 			le facteur de l'homothetie
	 * 
	 * @return les paramètres de la nouvelle ligne
	 */
	public Ligne homothetie(int k) {
		ArrayList<Point> extremites=new ArrayList<Point>();
		extremites.add(this.extremite1);
		extremites.add(this.extremite2);
		for (int i=0;i<2;i++) {
			double x=extremites.get(i).getX()*k;
			double y=extremites.get(i).getY()*k;
			extremites.add(new Point(x,y));
		}
		return new Ligne((int)this.centre.getX(), (int)this.centre.getY(), this.couleur,extremites.get(0), extremites.get(1), this.epaisseur);
	}
	
}
