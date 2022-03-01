public class UnitConverter {
    public int convertFromMetersToNm(int value){
        return value * Constants.NM_TO_METER;
    }

    public int convertFromFlToFeet(int value){
        return value * Constants.FL_TO_FEET;
    }

    public int convertFrom(int value){
        return value * Constants.FL_TO_FEET;
    }

    public double convertFromGallonsToLiters(int value){
        return value * Constants.GALLON_TO_LITER;
    }
}
