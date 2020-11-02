package ProjectForm;

public interface Technique {
	public Forme rotation(double degre) throws Exception;
	public Forme translation(int dx, int dy);
	public Forme homothetie(int k);

}
