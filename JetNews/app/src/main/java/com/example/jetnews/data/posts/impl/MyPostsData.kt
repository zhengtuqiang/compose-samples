import com.example.jetnews.R
import com.example.jetnews.data.posts.impl.florina
import com.example.jetnews.data.posts.impl.jose
import com.example.jetnews.data.posts.impl.manuel
import com.example.jetnews.data.posts.impl.paragraphsPost1
import com.example.jetnews.data.posts.impl.paragraphsPost2
import com.example.jetnews.data.posts.impl.paragraphsPost3
import com.example.jetnews.data.posts.impl.paragraphsPost4
import com.example.jetnews.data.posts.impl.paragraphsPost5
import com.example.jetnews.data.posts.impl.paragraphsPost6
import com.example.jetnews.data.posts.impl.pietro
import com.example.jetnews.data.posts.impl.publication
import com.example.jetnews.model.Metadata
import com.example.jetnews.model.Post

// 添加段落内容池
val allParagraphs = listOf(
    paragraphsPost1, paragraphsPost2, paragraphsPost3,
    paragraphsPost4, paragraphsPost5, paragraphsPost6
)

// 预定义真实标题模板
val titleTemplates = listOf(
    "深入理解%1\$s中的%2\$s",
    "%1\$s开发最佳实践",
    "%2\$s在%1\$s中的应用",
    "全面解析%1\$s的%2\$s功能"
)

// 预定义副标题模板
val subtitleTemplates = listOf(
    "深入解析%1\$s中的%2\$s实现",
    "最佳实践：如何优化%1\$s的%2\$s",
    "%1\$s开发必须掌握的%2\$s技巧",
    "解决%1\$s常见问题：%2\$s案例剖析"
)

// 技术领域关键词
val techDomains = listOf(
    "Kotlin协程",
    "Jetpack Compose",
    "Gradle插件",
    "性能优化"
)

// 技术细节关键词
val techDetails = listOf(
    "内存管理",
    "状态管理",
    "构建配置",
    "渲染管线"
)

// 生成真实感副标题
fun generateSubtitle(seed: Int): String {
    return subtitleTemplates[seed % subtitleTemplates.size].format(
        techDomains[seed % techDomains.size],
        techDetails[seed % techDetails.size]
    )
}

// 生成更真实的内容
val generatedFakePosts = (1..10000).map { index ->
    val seed = index % 6  // 基于现有6个模板的复用

    // 复用现有内容结构
    Post(
        id = "post${index + 11}",
        title = generateTitle(seed),
        subtitle = generateSubtitle(seed),
        url = "https://post/${index + 11}",
        publication = publication,
        metadata = Metadata(
            author = listOf(pietro, manuel, florina, jose).random(),
            date = generateDate(index),
            readTimeMinutes = (index % 10 + 1)
        ),
        paragraphs = allParagraphs[seed % allParagraphs.size],  // 复用已有段落结构
        imageId = when (seed) {  // 复用已有图片资源
            0 -> R.drawable.post_1
            1 -> R.drawable.post_2
            else -> R.drawable.post_3
        },
        imageThumbId = when (seed) {
            0 -> R.drawable.post_1_thumb
            1 -> R.drawable.post_2_thumb
            else -> R.drawable.post_3_thumb
        }
    )
}

// 生成真实日期（辅助函数）
fun generateDate(index: Int): String {
    val month = listOf("Jan", "Feb", "Mar", "Apr", "May", "Jun",
        "Jul", "Aug", "Sep", "Oct", "Nov", "Dec")[index % 12]
    return "$month ${index % 28 + 1}"
}

// 生成真实标题（辅助函数）
fun generateTitle(seed: Int): String {
    val techTerms = listOf("Kotlin", "Android Studio", "Jetpack Compose", "Dagger")
    val conceptTerms = listOf("模块化", "依赖注入", "性能优化", "UI设计")
    return titleTemplates[seed % titleTemplates.size]
        .format(techTerms[seed % techTerms.size], conceptTerms[seed % conceptTerms.size])
}
