# FirebaseVisionImageListener-Android

## Documentation

### Installation
---
Step 1. Add the JitPack repository to your build file 

```gradle
	allprojects {
		repositories {
			maven { url 'https://jitpack.io' }
		}
	}
```

Step 2. Add the dependency

```gradle
	dependencies {
            implementation 'com.github.rommansabbir:FirebaseVisionImageListener-Android:Tag'
	}
```

---

### Version available

| Releases        
| ------------- |
| v1.0.1        |


# Usages

### For Java: 

```java
public class MainActivity extends AppCompatActivity implements FirebaseVisionImageListener.FirebaseVisionImageListenerInterface {
    private FirebaseVisionImageListener firebaseVisionImageListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         /**
         * Instantiate FirebaseVisionImageListener with context
         */
        firebaseVisionImageListener = new FirebaseVisionImageListener(this);

        /**
         * Create a bitmap image object from resource or external/internal storage
         */
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.img);

        /**
         * Now simply pass the bitmap image object to the FirebaseVisionImageListener
         */
        firebaseVisionImageListener.getLabelsFromImage(bitmap);


    }

    @Override
    public void onFirebaseVisionImageSuccess(@NotNull List<String> labelsList) {
        //TODO Implement your logic here
    }

    @Override
    public void onFirebaseVisionImageFailure(@NotNull Exception exception) {
        //TODO Implement your logic here
    }
}
```




### For Kotlin: 

```kotlin
class MainActivity : AppCompatActivity(), FirebaseVisionImageListener.FirebaseVisionImageListenerInterface{
    private lateinit var firebaseVisionImageListener : FirebaseVisionImageListener
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         /**
         * Instantiate FirebaseVisionImageListener with context
         */
        firebaseVisionImageListener = FirebaseVisionImageListener(this);

        /**
         * Create a bitmap image object from resource or external/internal storage
         */
        val bitmap : Bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.img);

        /**
         * Now simply pass the bitmap image object to the FirebaseVisionImageListener
         */
        firebaseVisionImageListener.getLabelsFromImage(bitmap)

    }

    override fun onFirebaseVisionImageSuccess(@NotNull List<String> labelsList) {
        //TODO Implement your logic here
    }

    override fun onFirebaseVisionImageFailure(@NotNull Exception exception) {
        //TODO Implement your logic here
    }
}
```

### Contact me
[Portfolio](https://www.rommansabbir.com/) | [LinkedIn](https://www.linkedin.com/in/rommansabbir/) | [Twitter](https://www.twitter.com/itzrommansabbir/) | [Facebook](https://www.facebook.com/itzrommansabbir/)


