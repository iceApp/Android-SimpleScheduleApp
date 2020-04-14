package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.ImportFlag;
import io.realm.ProxyUtils;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsList;
import io.realm.internal.OsObject;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.Property;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import io.realm.internal.objectstore.OsObjectBuilder;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("all")
public class com_example_myscheduler_ScheduleRealmProxy extends com.example.myscheduler.Schedule
    implements RealmObjectProxy, com_example_myscheduler_ScheduleRealmProxyInterface {

    static final class ScheduleColumnInfo extends ColumnInfo {
        long maxColumnIndexValue;
        long idIndex;
        long dateIndex;
        long titleIndex;
        long detailIndex;

        ScheduleColumnInfo(OsSchemaInfo schemaInfo) {
            super(4);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("Schedule");
            this.idIndex = addColumnDetails("id", "id", objectSchemaInfo);
            this.dateIndex = addColumnDetails("date", "date", objectSchemaInfo);
            this.titleIndex = addColumnDetails("title", "title", objectSchemaInfo);
            this.detailIndex = addColumnDetails("detail", "detail", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        ScheduleColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new ScheduleColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final ScheduleColumnInfo src = (ScheduleColumnInfo) rawSrc;
            final ScheduleColumnInfo dst = (ScheduleColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.dateIndex = src.dateIndex;
            dst.titleIndex = src.titleIndex;
            dst.detailIndex = src.detailIndex;
            dst.maxColumnIndexValue = src.maxColumnIndexValue;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private ScheduleColumnInfo columnInfo;
    private ProxyState<com.example.myscheduler.Schedule> proxyState;

    com_example_myscheduler_ScheduleRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (ScheduleColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.example.myscheduler.Schedule>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public long realmGet$id() {
        proxyState.getRealm$realm().checkIfValid();
        return (long) proxyState.getRow$realm().getLong(columnInfo.idIndex);
    }

    @Override
    public void realmSet$id(long value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'id' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public Date realmGet$date() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.util.Date) proxyState.getRow$realm().getDate(columnInfo.dateIndex);
    }

    @Override
    public void realmSet$date(Date value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'date' to null.");
            }
            row.getTable().setDate(columnInfo.dateIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field 'date' to null.");
        }
        proxyState.getRow$realm().setDate(columnInfo.dateIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$title() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.titleIndex);
    }

    @Override
    public void realmSet$title(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'title' to null.");
            }
            row.getTable().setString(columnInfo.titleIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field 'title' to null.");
        }
        proxyState.getRow$realm().setString(columnInfo.titleIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$detail() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.detailIndex);
    }

    @Override
    public void realmSet$detail(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'detail' to null.");
            }
            row.getTable().setString(columnInfo.detailIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field 'detail' to null.");
        }
        proxyState.getRow$realm().setString(columnInfo.detailIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("Schedule", 4, 0);
        builder.addPersistedProperty("id", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("date", RealmFieldType.DATE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("title", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("detail", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static ScheduleColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new ScheduleColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "Schedule";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "Schedule";
    }

    @SuppressWarnings("cast")
    public static com.example.myscheduler.Schedule createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.example.myscheduler.Schedule obj = null;
        if (update) {
            Table table = realm.getTable(com.example.myscheduler.Schedule.class);
            ScheduleColumnInfo columnInfo = (ScheduleColumnInfo) realm.getSchema().getColumnInfo(com.example.myscheduler.Schedule.class);
            long pkColumnIndex = columnInfo.idIndex;
            long rowIndex = Table.NO_MATCH;
            if (!json.isNull("id")) {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong("id"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.example.myscheduler.Schedule.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_example_myscheduler_ScheduleRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.com_example_myscheduler_ScheduleRealmProxy) realm.createObjectInternal(com.example.myscheduler.Schedule.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_example_myscheduler_ScheduleRealmProxy) realm.createObjectInternal(com.example.myscheduler.Schedule.class, json.getLong("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }

        final com_example_myscheduler_ScheduleRealmProxyInterface objProxy = (com_example_myscheduler_ScheduleRealmProxyInterface) obj;
        if (json.has("date")) {
            if (json.isNull("date")) {
                objProxy.realmSet$date(null);
            } else {
                Object timestamp = json.get("date");
                if (timestamp instanceof String) {
                    objProxy.realmSet$date(JsonUtils.stringToDate((String) timestamp));
                } else {
                    objProxy.realmSet$date(new Date(json.getLong("date")));
                }
            }
        }
        if (json.has("title")) {
            if (json.isNull("title")) {
                objProxy.realmSet$title(null);
            } else {
                objProxy.realmSet$title((String) json.getString("title"));
            }
        }
        if (json.has("detail")) {
            if (json.isNull("detail")) {
                objProxy.realmSet$detail(null);
            } else {
                objProxy.realmSet$detail((String) json.getString("detail"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.example.myscheduler.Schedule createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.example.myscheduler.Schedule obj = new com.example.myscheduler.Schedule();
        final com_example_myscheduler_ScheduleRealmProxyInterface objProxy = (com_example_myscheduler_ScheduleRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$id((long) reader.nextLong());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'id' to null.");
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("date")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$date(null);
                } else if (reader.peek() == JsonToken.NUMBER) {
                    long timestamp = reader.nextLong();
                    if (timestamp > -1) {
                        objProxy.realmSet$date(new Date(timestamp));
                    }
                } else {
                    objProxy.realmSet$date(JsonUtils.stringToDate(reader.nextString()));
                }
            } else if (name.equals("title")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$title((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$title(null);
                }
            } else if (name.equals("detail")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$detail((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$detail(null);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
        }
        return realm.copyToRealm(obj);
    }

    private static com_example_myscheduler_ScheduleRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.example.myscheduler.Schedule.class), false, Collections.<String>emptyList());
        io.realm.com_example_myscheduler_ScheduleRealmProxy obj = new io.realm.com_example_myscheduler_ScheduleRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.example.myscheduler.Schedule copyOrUpdate(Realm realm, ScheduleColumnInfo columnInfo, com.example.myscheduler.Schedule object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null) {
            final BaseRealm otherRealm = ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm();
            if (otherRealm.threadId != realm.threadId) {
                throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
            }
            if (otherRealm.getPath().equals(realm.getPath())) {
                return object;
            }
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.example.myscheduler.Schedule) cachedRealmObject;
        }

        com.example.myscheduler.Schedule realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.example.myscheduler.Schedule.class);
            long pkColumnIndex = columnInfo.idIndex;
            long rowIndex = table.findFirstLong(pkColumnIndex, ((com_example_myscheduler_ScheduleRealmProxyInterface) object).realmGet$id());
            if (rowIndex == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), columnInfo, false, Collections.<String> emptyList());
                    realmObject = new io.realm.com_example_myscheduler_ScheduleRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, columnInfo, realmObject, object, cache, flags) : copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.example.myscheduler.Schedule copy(Realm realm, ScheduleColumnInfo columnInfo, com.example.myscheduler.Schedule newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.example.myscheduler.Schedule) cachedRealmObject;
        }

        com_example_myscheduler_ScheduleRealmProxyInterface realmObjectSource = (com_example_myscheduler_ScheduleRealmProxyInterface) newObject;

        Table table = realm.getTable(com.example.myscheduler.Schedule.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);

        // Add all non-"object reference" fields
        builder.addInteger(columnInfo.idIndex, realmObjectSource.realmGet$id());
        builder.addDate(columnInfo.dateIndex, realmObjectSource.realmGet$date());
        builder.addString(columnInfo.titleIndex, realmObjectSource.realmGet$title());
        builder.addString(columnInfo.detailIndex, realmObjectSource.realmGet$detail());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_example_myscheduler_ScheduleRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        return realmObjectCopy;
    }

    public static long insert(Realm realm, com.example.myscheduler.Schedule object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.myscheduler.Schedule.class);
        long tableNativePtr = table.getNativePtr();
        ScheduleColumnInfo columnInfo = (ScheduleColumnInfo) realm.getSchema().getColumnInfo(com.example.myscheduler.Schedule.class);
        long pkColumnIndex = columnInfo.idIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((com_example_myscheduler_ScheduleRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_example_myscheduler_ScheduleRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_example_myscheduler_ScheduleRealmProxyInterface) object).realmGet$id());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        java.util.Date realmGet$date = ((com_example_myscheduler_ScheduleRealmProxyInterface) object).realmGet$date();
        if (realmGet$date != null) {
            Table.nativeSetTimestamp(tableNativePtr, columnInfo.dateIndex, rowIndex, realmGet$date.getTime(), false);
        }
        String realmGet$title = ((com_example_myscheduler_ScheduleRealmProxyInterface) object).realmGet$title();
        if (realmGet$title != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
        }
        String realmGet$detail = ((com_example_myscheduler_ScheduleRealmProxyInterface) object).realmGet$detail();
        if (realmGet$detail != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.detailIndex, rowIndex, realmGet$detail, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.myscheduler.Schedule.class);
        long tableNativePtr = table.getNativePtr();
        ScheduleColumnInfo columnInfo = (ScheduleColumnInfo) realm.getSchema().getColumnInfo(com.example.myscheduler.Schedule.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.example.myscheduler.Schedule object = null;
        while (objects.hasNext()) {
            object = (com.example.myscheduler.Schedule) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((com_example_myscheduler_ScheduleRealmProxyInterface) object).realmGet$id();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_example_myscheduler_ScheduleRealmProxyInterface) object).realmGet$id());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_example_myscheduler_ScheduleRealmProxyInterface) object).realmGet$id());
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, rowIndex);
            java.util.Date realmGet$date = ((com_example_myscheduler_ScheduleRealmProxyInterface) object).realmGet$date();
            if (realmGet$date != null) {
                Table.nativeSetTimestamp(tableNativePtr, columnInfo.dateIndex, rowIndex, realmGet$date.getTime(), false);
            }
            String realmGet$title = ((com_example_myscheduler_ScheduleRealmProxyInterface) object).realmGet$title();
            if (realmGet$title != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
            }
            String realmGet$detail = ((com_example_myscheduler_ScheduleRealmProxyInterface) object).realmGet$detail();
            if (realmGet$detail != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.detailIndex, rowIndex, realmGet$detail, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.example.myscheduler.Schedule object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.myscheduler.Schedule.class);
        long tableNativePtr = table.getNativePtr();
        ScheduleColumnInfo columnInfo = (ScheduleColumnInfo) realm.getSchema().getColumnInfo(com.example.myscheduler.Schedule.class);
        long pkColumnIndex = columnInfo.idIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((com_example_myscheduler_ScheduleRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_example_myscheduler_ScheduleRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_example_myscheduler_ScheduleRealmProxyInterface) object).realmGet$id());
        }
        cache.put(object, rowIndex);
        java.util.Date realmGet$date = ((com_example_myscheduler_ScheduleRealmProxyInterface) object).realmGet$date();
        if (realmGet$date != null) {
            Table.nativeSetTimestamp(tableNativePtr, columnInfo.dateIndex, rowIndex, realmGet$date.getTime(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.dateIndex, rowIndex, false);
        }
        String realmGet$title = ((com_example_myscheduler_ScheduleRealmProxyInterface) object).realmGet$title();
        if (realmGet$title != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.titleIndex, rowIndex, false);
        }
        String realmGet$detail = ((com_example_myscheduler_ScheduleRealmProxyInterface) object).realmGet$detail();
        if (realmGet$detail != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.detailIndex, rowIndex, realmGet$detail, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.detailIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.myscheduler.Schedule.class);
        long tableNativePtr = table.getNativePtr();
        ScheduleColumnInfo columnInfo = (ScheduleColumnInfo) realm.getSchema().getColumnInfo(com.example.myscheduler.Schedule.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.example.myscheduler.Schedule object = null;
        while (objects.hasNext()) {
            object = (com.example.myscheduler.Schedule) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((com_example_myscheduler_ScheduleRealmProxyInterface) object).realmGet$id();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_example_myscheduler_ScheduleRealmProxyInterface) object).realmGet$id());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_example_myscheduler_ScheduleRealmProxyInterface) object).realmGet$id());
            }
            cache.put(object, rowIndex);
            java.util.Date realmGet$date = ((com_example_myscheduler_ScheduleRealmProxyInterface) object).realmGet$date();
            if (realmGet$date != null) {
                Table.nativeSetTimestamp(tableNativePtr, columnInfo.dateIndex, rowIndex, realmGet$date.getTime(), false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.dateIndex, rowIndex, false);
            }
            String realmGet$title = ((com_example_myscheduler_ScheduleRealmProxyInterface) object).realmGet$title();
            if (realmGet$title != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.titleIndex, rowIndex, false);
            }
            String realmGet$detail = ((com_example_myscheduler_ScheduleRealmProxyInterface) object).realmGet$detail();
            if (realmGet$detail != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.detailIndex, rowIndex, realmGet$detail, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.detailIndex, rowIndex, false);
            }
        }
    }

    public static com.example.myscheduler.Schedule createDetachedCopy(com.example.myscheduler.Schedule realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.example.myscheduler.Schedule unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.example.myscheduler.Schedule();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.example.myscheduler.Schedule) cachedObject.object;
            }
            unmanagedObject = (com.example.myscheduler.Schedule) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_example_myscheduler_ScheduleRealmProxyInterface unmanagedCopy = (com_example_myscheduler_ScheduleRealmProxyInterface) unmanagedObject;
        com_example_myscheduler_ScheduleRealmProxyInterface realmSource = (com_example_myscheduler_ScheduleRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$date(realmSource.realmGet$date());
        unmanagedCopy.realmSet$title(realmSource.realmGet$title());
        unmanagedCopy.realmSet$detail(realmSource.realmGet$detail());

        return unmanagedObject;
    }

    static com.example.myscheduler.Schedule update(Realm realm, ScheduleColumnInfo columnInfo, com.example.myscheduler.Schedule realmObject, com.example.myscheduler.Schedule newObject, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        com_example_myscheduler_ScheduleRealmProxyInterface realmObjectTarget = (com_example_myscheduler_ScheduleRealmProxyInterface) realmObject;
        com_example_myscheduler_ScheduleRealmProxyInterface realmObjectSource = (com_example_myscheduler_ScheduleRealmProxyInterface) newObject;
        Table table = realm.getTable(com.example.myscheduler.Schedule.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);
        builder.addInteger(columnInfo.idIndex, realmObjectSource.realmGet$id());
        builder.addDate(columnInfo.dateIndex, realmObjectSource.realmGet$date());
        builder.addString(columnInfo.titleIndex, realmObjectSource.realmGet$title());
        builder.addString(columnInfo.detailIndex, realmObjectSource.realmGet$detail());

        builder.updateExistingObject();
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Schedule = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{date:");
        stringBuilder.append(realmGet$date());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{title:");
        stringBuilder.append(realmGet$title());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{detail:");
        stringBuilder.append(realmGet$detail());
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long rowIndex = proxyState.getRow$realm().getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        com_example_myscheduler_ScheduleRealmProxy aSchedule = (com_example_myscheduler_ScheduleRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aSchedule.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aSchedule.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aSchedule.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
