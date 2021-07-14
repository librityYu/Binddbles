这个项目是仿照 [项目](https://github.com/skydoves/Bindables) 写的。主要是学习DataBinding的学习。

#### 1. 里面学习到了Databinding实现的数据双向绑定：

  * 更新单个数据需要使用notifyPropertyChanged(BR.id)
  * 更新全部数据使用notifyChange()
    
```kotlin
class Student : BaseObservable {

    @Bindable
    var name: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.name)
        }
}
```
#### 2. kotlin增加的新属性：takeIf 和 takeUnless
* takeIf：如果匹配为true那么就返回对象本身，否则返回null
* takeUnless：如果不匹配就返回对象本身，否则返回null
```kotlin
import kotlin.random.*
/**
* 当takeIf里面的表达式返回true 那么就返回自身      否则就返回null
* 当takeUnless里面的表达式返回false 那么就返回本身 否则返回null
*/
fun main() {
    val number = Random.nextInt(100)

    val evenOrNull = number.takeIf { it % 2 == 0 }
    val oddOrNull = number.takeUnless { it % 2 == 0 }
    println("even: $evenOrNull, odd: $oddOrNull")
}
// even: 76, odd: null
// even: null, odd: 29
// even: 12, odd: null
```
#### 3. 学习了kotlin的代理
了解到kotlin的代理就是通过by的方式实现。在这个项目使用到的地方：
     
 ```kotlin
  @get:Bindable
    val data: List<Poster> by stateFlow.asBindingProperty()
 ```


#### 更多知识总结:[浏览我的博客](https://librityYu.github.io)
