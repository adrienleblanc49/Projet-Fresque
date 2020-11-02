package ProjectForm;

/**
 * <b>Point est la classe repr�sentant les coordonn�es d'un point
 * <p>
 * Un point est caract�ris� par les informations suivantes :
 * <ul>
 * <li>une coordonn�e selon x.</li>
 * <li>une coordonn�e selon y.</li>
 * </ul>
 * </p>
 */
public class Point {
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		return true;
	}

	protected final double x;
	protected final double y;
	
	/**
	 * Constructeur Point � deux param�tres
	 * @param x
	 * 			La coordonn�e du Point selon x
	 * @param y
	 * 			La coordonn�e du Point selon y
	 */
	public Point(final int x, final int y){
		this.x = x;
		this.y = y;
	}
	
	public Point(final double x, final double y){
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Constructeur Point � l'origine.
	 * <p>
	 * Le point est construit � l'origine du rep�re en (0,0)
	 * </p>
	 */
	public Point() {
		this(0,0);

		/** A la place de
		this.x = 0;
		this.y = 0;
		 */
	}

	// Attention : final indique que la référence b est constante
	// "on ne peut pas changer de point" dans le corps de la méthode
	/**
	 * Constructeur Point de type copie.
	 * <p>
	 * Le constructeur cr�er un Point � partir d'un autre d�ja existant.
	 * </p>
	 * 
	 * @param b
	 * 			Le point d�ja existant servant de mod�le.
	 */
	public Point(final Point b){
		this(b.x,b.y);

		/** A la place de
		this.x = b.x;
		this.y = b.y;
		 */
	}

	// ACCESSEURS EN LECTURE
	/**
	 * Retourne la coordonn�e x du point.
	 * 
	 * @return La coordonn�e selon x du Point, sous forme d'entier.
	 */
	public double getX() {
		return x;
	}


	/**
	 * Retourne la coordonn�e y du point.
	 * 
	 * @return La coordonn�e selon y du Point, sous forme d'entier.
	 */
	public double getY() {
		return y;
	}

	/** Un point est immutable donc pas d'accesseurs en écriture
	public void setX(final int x) {
		this.x = x;
	}

	public void setY(final int y) {
		this.y = y;
	}
	 */

	/**
	 * Retourne la distance entre ce point et celui en param�tre.
	 * 
	 * @param p
	 * 			Le point � partir duquel on calcul a la distance de ce point.
	 * 
	 * @return La distance entre ce point et le point en param�tre, sous forme de double.
	 */
	public double distance(final Point p) {
		// les 2 lignes suivantes ne compilent pas!
		// Pourquoi final ....
		// p.x = 12;
		// p = new Point();
		/*	
		double a = ((this.x) - (p.x)) * ((this.x) - (p.x));
		double b = ((this.y) - (p.y)) * ((this.y) - (p.y));
		return Math.sqrt((a + b));
		 */	
		return Math.sqrt(((this.x) - (p.x)) * ((this.x) - (p.x)) + ((this.y) - (p.y)) * ((this.y) - (p.y)));
	}
	/**
	translation est une méthode d’instance
	p1 antécédent en Maths
	p2 image en Maths (nouveau point)

	p2 = p1.translation(6, 2) ;

	p1 est immutable
	p2 aussi..

	en Maths
	translation :   Points   ----→ Points
					P(x, y) |----→ P’(x’, y’)
	x’ = x + dx;
	y’ = y + dy;

    en Java : translation est une méthode d’instance
	public Point translation(final int dx, final int dy){

	}
	 */
	// copie défensive car point immutable
	/**
	 * Translate un point � une nouvelle position.
	 * 
	 * @param dx
	 * 			Valeur du d�placement du point selon x.
	 * @param dy
	 * 			Valeur du d�placement du point selon y.
	 * 
	 * @return Le Point translat� � sa nouvelle position.
	 */
	public Point translation(final int dx, final int dy) {
		return new Point(x + dx, y + dy);
	}

	/**
	pas d'annotation @Override
	==> tostring ERREUR NON DETECTEE
	la méthode toString n'est donc pas redéfinie!
	celle qui est activée est donc la méthode héritée toString de la classe Object
	elle retourne l'identifiant unique de l'objet (instance)

	p1 = exo3.Point@4f023edb
	p2 = exo3.Point@3a71f4dd
	p3 = exo3.Point@7adf9f5f
	public String tostring(){
		return "(" + x + "," + y + ")";
	}
	 */

	/**
	tostring ERREUR DETECTEE grâce à l'annotation @Override
	NE COMPILE PAS avec le messsage d'erreur : 
	the method tostring() of type Point must override or implement a supertype method

	le supertype est le type Object qui implémente déjà la méthode toString en retournant
	l'identifiant unique de l'objet (instance)
	Il faut donc la redéfinir(override) dans la classe Point sous-classe de Object

	@Override
	public String tostring(){
		return "(" + x + "," + y + ")";
	}
	 */

	/**
	 * Renvoi les coordonn�es du point.
	 * 
	 * @return Les coordonn�es du point, sous forme de cha�ne de caract�re.
	 */
	@Override
	public String toString(){
		return "(" + x + "," + y + ")";
	}
}
