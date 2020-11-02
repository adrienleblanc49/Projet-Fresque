package ProjectForm;
import java.util.ArrayList;
/**
 * <b>Polygone est la classe représentant la forme géométrique éponyme et hérite de la classe Forme.
 * <p>
 * Un polygone est caractérisé par l'information suivante :
 * <ul>
 * <li>Son nombre de sommets.</li>
 * </ul>
 * </p>
 */
public class Polygone extends Forme  {
	//Attributs
	protected ArrayList<Point> sommets;
	
	//Constructeurs
	public Polygone() {
		
	}
	
	/**
	 * Constructeur Polygone à 6 paramètres pour créer un rectangle plus facilement
	 * @param x
	 * 			La coordonnée du centre selon x.
	 * @param y
	 * 			La coordonnée du centre selon y.
	 * @param couleur
	 * 			La couleur du Polygone rectangulaire.
	 * @param p1
	 * 			Le premier point du rectangle.
	 * @param longueur
	 * 			La longueur du rectangle.
	 * @param largeur
	 * 			La largeur du rectangle.
	 */
	
	public Polygone(final int x, final int y, final Couleur couleur, Point p1, int longueur, int largeur) {
		super(x,y,couleur);
		this.sommets.add(p1);
		this.sommets.add(p1.translation(longueur, 0));
        this.sommets.add(p1.translation(0, largeur));
        this.sommets.add(p1.translation(longueur, largeur));
	}
	
	/**
	 * Constructeur Polygone à 4 paramètres
	 * @param x
	 * 			La coordonnée du centre selon x.
	 * @param y
	 * 			La coordonnée du centre selon y.
	 * @param couleur
	 * 			La couleur du Polygone.
	 * @param points
	 * 			Les points qui constituent le Polygone.
	 */
	
	public Polygone(final int x, final int y, final Couleur couleur, ArrayList<Point> points) {
		super(x,y,couleur);
		this.sommets=points;
	}
	
	//Methodes
	/**
	 * Retourne le nombre de sommets du polygone.
	 * 
	 * @return Le nombre de sommets, sous forme d'entier.
	 */
	public int getNbSommets() {
		return this.sommets.size();
	}
	
	/**
	 * Ajoute un point au polygone.
	 * 
	 * @param p
	 * 			Le point que l'on souhaite ajouter.
	 * @param position
	 * 			un int representant la position du point a ajouter dans le tableau (comprise entre 1 et this.getNbSommets()+1).
	 */
	public void ajoutPoint(Point p, int position) {
			this.sommets.add(position,p);
	}
	
	/**
	 * Retire un point du polygone.
	 * 
	 * @param position
	 * 			un int representant la position du point a retirer dans le tableau (comprise entre 1 et this.getNbSommets()+1).
	 */
	public void retirePoint(int position) {
		this.sommets.remove(position);
	}
	
	/**
	 * Retourne le point en position i du polygone
	 * 
	 * @param i
	 * 			Un int représentant la position du point que l'on veut retourner.
	 * 
	 * @return Le point en position i, sous forme de Point.
	 */
	public Point getPoint(int i) {
		return this.sommets.get(i);
	}
	
	
	/**
	 * Renvoi les coordonnées des points qui constituent le polygone.
	 * 
	 * @return les coordonnées des points qui constituent le polygone, sous forme de chaîne de caractère.
	 */
	@Override
    public String toString()    {
		if (this.sommets.size()==3) {
        	return "triangle " +this.couleur+" aux 3 sommets : (p1: "+this.sommets.get(0).toString()+", p2: "+this.sommets.get(1).toString()+", p3: "+this.sommets.get(2).toString()+" )";
		}
		else if (this.sommets.size()==4) {
			return "Rectangle " +this.couleur+" aux 4 sommets : (p1: "+this.sommets.get(0).toString()+", p2: "+this.sommets.get(1).toString()+", p3: "+this.sommets.get(2).toString()+ ", p4: " +this.sommets.get(3).toString() +" )";
		}
		else {
			String fill="";
			for (int i=0; i<this.sommets.size();i++) {
				fill+= "p"+i+": "+ this.sommets.get(i).toString()+ ", ";
			}
			return "Polygone " + this.couleur +" à "+ this.sommets.size() + " sommets : (" + fill  +")";
		}
	}
	/**
	 * Renvoi le perimetre du polygone.
	 * 
	 * @return La valeur du perimetre du polygone, sous forme de double.
	 */
		@Override
	    public double perimetre() {
			if (this.sommets.size()==4) {
				double p = (sommets.get(0).distance(sommets.get(1))*2 + sommets.get(0).distance(sommets.get(2))*2) ;
				System.out.println("périmètre du rectangle: ");
				return p;
			}
			else if (this.sommets.size()==3) {
				double ptri = (sommets.get(0).distance(sommets.get(1)) + sommets.get(1).distance(sommets.get(2)) + sommets.get(2).distance(sommets.get(0))) ;
		        System.out.println("périmètre du triangle: ");
		        return ptri;
			}
			else {
				double p=0;
				for (int i=0; i<sommets.size()-1;i++) {
					p+=sommets.get(i).distance(sommets.get(i+1));
				}
				System.out.println("périmètre du polygone: ");
				return p;
				
			}		
		}
		
		/**
		 * Renvoi l'aire du polygone.
		 * 
		 * @return La valeur de l'aire du polygone, sous forme de double.
		 */
		public double aire() {
			if (this.sommets.size()==3) {
				double s=(sommets.get(0).distance(sommets.get(1)) + sommets.get(1).distance(sommets.get(2)) + sommets.get(2).distance(sommets.get(0)))/2;
				double a=sommets.get(0).distance(sommets.get(1));
				double b=sommets.get(1).distance(sommets.get(2));
				double c=sommets.get(2).distance(sommets.get(0));
				System.out.print("l'aire de ce triangle est : ");
				return Math.sqrt(s*(s-a)*(s-b)*(s-c));
			}
			else if (this.sommets.size()==4) {
				double longueur=sommets.get(0).distance(sommets.get(1));
		    	double largeur=sommets.get(0).distance(sommets.get(2));
		    	System.out.print("l'aire de ce rectangle est : ");
		        return longueur*largeur;
			}
			else {
				boolean convexe;
				for(int i=0 ;i<sommets.size()-2;i++) {
					if (sommets.get(i).distance(sommets.get(i+1))==sommets.get(i+1).distance(sommets.get(i+2))){
						convexe=true;
					}
				}
				if (convexe=true) {
					System.out.print("Le Polygone est convexe et son aire vaut: ");
					double longueurCote=sommets.get(0).distance(sommets.get(1));
					double h= longueurCote/(2*Math.tan(Math.PI/this.sommets.size()));
					return h;
					}
				else {
					System.out.print("Le Polygone n'est pas convexe, on ne connait pas son aire");
					return 0;
			}
	    }
		
	}
		/**
		 * Renvoie un nouveau polygone identique translaté
		 * @param dx
		 * 			valeur de la translation selon l'axe horizontal x
		 * @param dy
		 * 			valeur de la translation selon l'axe vertical y 
		 * @return les paramètres du nouveau polygone
		 */
		public Polygone translation(int dx, int dy) {
			ArrayList<Point> sommets2=new ArrayList<Point>();
				for(int i=0; i< this.sommets.size(); i++) {
					double x=this.sommets.get(i).getX()+dx;
					double y=this.sommets.get(i).getY()+dy;
					sommets2.add(new Point(x,y));
				}
				return new Polygone((int)centre.getX()+dx,(int)centre.getY()+dy, couleur, sommets2);
		}
		
		/**
		 * Renvoie un nouveau polygone identique pivoté d'un angle "degree" dans le sens horaire.
		 * 
		 * @param degree
		 * 				La valeur de l'angle dont on souhaite pivoter le polygone 
		 * 
		 * @return les paramètres du nouveau polygone
		 */
		public Polygone rotation (double degre) throws Exception {
			double d=degre*Math.PI/180;
			double [][] Vect=new double [2][1];
			double[][] matriceRot=new double[2][2];
			ArrayList<Point> points=new ArrayList<Point>();
			matriceRot[0][0]=Math.cos(d);
			matriceRot[0][1]=Math.sin(d);
			matriceRot[1][0]=-matriceRot[0][1];
			matriceRot[1][1]=matriceRot[0][0];
			for (int i=0; i<sommets.size();i++) {
				double x=sommets.get(i).getX();
				double y=sommets.get(i).getY();
				Vect[0][0]=x;
				Vect[1][0]=y;
				Point pointNew =new Point(multiplier(matriceRot, Vect)[0][0],multiplier(matriceRot, Vect)[1][0]);
				points.add(pointNew);
			}
			return new Polygone((int)this.centre.getX(), (int)this.centre.getY(), this.couleur, points);
			
		}
		
		/**
		 * Renvoie l'homothetie du polygone
		 * 
		 * @param k
		 * 			le facteur de l'homothetie
		 * 
		 * @return les paramètres du nouveau polygone
		 */
		public Polygone homothetie(int k) {
			ArrayList<Point> points=new ArrayList<Point>();
			for (int i=0;i<this.sommets.size();i++) {
				double x=sommets.get(i).getX()*k;
				double y=sommets.get(i).getY()*k;
				points.add(new Point(x,y));
			}
			return new Polygone((int)this.centre.getX(), (int)this.centre.getY(), this.couleur,points);
		}
		
		
		
}
