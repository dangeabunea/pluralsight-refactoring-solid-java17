public class UnitConverter {
    public int convertFromMetersToNm(int value){
        return value * UnitConversionConstants.NM_TO_METER;
    }

    public double convertFromGallonsToLiters(int value){
        return value * UnitConversionConstants.GALLON_TO_LITER;
    }
}
