public class CurrencyConverter {
    public double Pkr(double bal){
        return bal;
    }
    public double PkrtoUsd(double bal){
        double pkrBal;
        pkrBal = bal/287;
        return pkrBal;
    }
    public double PkrtoPound(double bal){
        double poundBal;
        poundBal = bal/351.53;
        return poundBal;
    }
    public double PkrtoEuro(double bal){
        double euroBal;
        euroBal = bal/306.54;
        return euroBal;
    }
    public double PkrtoYen(double bal){
        double yenBal;
        yenBal = bal/1.94;
        return yenBal;
    }
    public double PkrtoRinggitt(double bal){
        double ringgitBal;
        ringgitBal = bal/61.22;
        return ringgitBal;
    }
}
