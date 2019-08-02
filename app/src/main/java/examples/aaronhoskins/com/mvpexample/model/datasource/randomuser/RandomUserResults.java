
package examples.aaronhoskins.com.mvpexample.model.datasource.randomuser;

import java.util.ArrayList;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RandomUserResults implements Parcelable
{

    @SerializedName("results")
    @Expose
    private List<Result> results = new ArrayList<>();
    @SerializedName("info")
    @Expose
    private Info info;
    public final static Creator<RandomUserResults> CREATOR = new Creator<RandomUserResults>() {


        @SuppressWarnings({
            "unchecked"
        })
        public RandomUserResults createFromParcel(Parcel in) {
            return new RandomUserResults(in);
        }

        public RandomUserResults[] newArray(int size) {
            return (new RandomUserResults[size]);
        }

    }
    ;

    protected RandomUserResults(Parcel in) {
        in.readList(this.results, (examples.aaronhoskins.com.mvpexample.model.datasource.randomuser.Result.class.getClassLoader()));
        this.info = ((Info) in.readValue((Info.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public RandomUserResults() {
    }

    /**
     * 
     * @param results
     * @param info
     */
    public RandomUserResults(List<Result> results, Info info) {
        super();
        this.results = results;
        this.info = info;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(results);
        dest.writeValue(info);
    }

    public int describeContents() {
        return  0;
    }

}
