#include <jni.h>
#include <string>

extern "C"
JNIEXPORT jstring JNICALL
Java_vn_com_vng_todoapp_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}
