
public class binSearchRec {
	protected int[] nums;
	boolean binSearchRec(int findindex, int firstindex, int lastindex) {
		int mid = (firstindex + lastindex) / 2;
		if ( firstindex> lastindex) {
			return false;
		}
		else {
			if (findindex == nums[mid]) {
				return true;
			}
			else {
				if (findindex > nums[mid]) {
					return binSearchRec(findindex, mid + 1, lastindex);
				}
				else if (findindex < nums[mid]) {
					return binSearchRec(findindex, firstindex, mid -1);
				}
			}
		}
		return false;
		
	}

}
