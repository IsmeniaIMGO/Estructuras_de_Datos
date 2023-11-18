package services;

public interface ILogin {
    public boolean verificarRegular(String usser, String password);

    public boolean verificarPremium(String usser, String password);


}
