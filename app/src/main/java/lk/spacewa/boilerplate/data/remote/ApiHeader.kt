package lk.spacewa.boilerplate.data.remote

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import lk.spacewa.boilerplate.di.ApiInfo
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Imdad on 05/11/20.
 */
@Singleton
class ApiHeader @Inject constructor(val publicApiHeader: PublicApiHeader, val protectedApiHeader: ProtectedApiHeader) {

    class ProtectedApiHeader(@field:SerializedName("api_key") @field:Expose var apiKey: String?, @field:SerializedName("user_id") @field:Expose var userId: Long?, @field:SerializedName("access_token") @field:Expose var accessToken: String?)

    class PublicApiHeader @Inject constructor(@field:SerializedName("api_key") @field:Expose @param:ApiInfo var apiKey: String)

}