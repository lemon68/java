package pay.pingplusplus.serializer;

import com.google.gson.*;
import com.pingplusplus.model.App;
import com.pingplusplus.model.ChargeRefundCollection;
import com.pingplusplus.model.RedEnvelope;

import java.lang.reflect.Type;

/**
 * Created by sunkai on 15/5/14.
 */
public class RedEnvelopeDeserializer implements JsonDeserializer<RedEnvelope> {
    @Override
    public RedEnvelope deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject transFerJson = json.getAsJsonObject();
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).
                registerTypeAdapter(ChargeRefundCollection.class, new ChargeRefundCollectionDeserializer())
                .create();
        JsonElement appElement = transFerJson.get("app");
        RedEnvelope redEnvelope = gson.fromJson(json, RedEnvelope.class);

        if (null != appElement && appElement.isJsonObject()) {
            App app = gson.fromJson(appElement, App.class);
            redEnvelope.setApp(app);
        }
        return redEnvelope;
    }
}
