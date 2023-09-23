public class CurrencyConverter {
    public double Pkr(double bal){
        return bal;
    }
    public double PkrtoUsd(double bal){
        double pkrBal;
        pkrBal = bal/210;
        return pkrBal;
    }
    public double PkrtoPound(double bal){
        double poundBal;
        poundBal = bal/255.27;
        return poundBal;
    }
    public double PkrtoEuro(double bal){
        double euroBal;
        euroBal = bal/219.01;
        return euroBal;
    }
    public double PkrtoYen(double bal){
        double yenBal;
        yenBal = bal/1.55;
        return yenBal;
    }
    public double PkrtoRinggitt(double bal){
        double ringgitBal;
        ringgitBal = bal/47.53;
        return ringgitBal;
    }
}
