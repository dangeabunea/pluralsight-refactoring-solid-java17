public class UnitConverter {
    public int convertFromMetersToNm(int value){
        return value * Constants.NM_TO_METER;
    }

    public double convertFromGallonsToLiters(int value){
        return value * Constants.GALLON_TO_LITER;
    }
}
