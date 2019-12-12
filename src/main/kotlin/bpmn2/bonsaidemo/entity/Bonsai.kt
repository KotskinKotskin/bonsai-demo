package bpmn2.bonsaidemo.entity

import org.hibernate.annotations.Type
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.io.Serializable
import java.time.LocalDateTime
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EntityListeners
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Lob

@Entity
@EntityListeners(AuditingEntityListener::class)
data class Bonsai(
    @Id
    @GeneratedValue
    @Column(columnDefinition = "UUID", updatable = false )
    val id: UUID  = UUID.randomUUID(),

    @Column(name = "name")
    var name: String?,

    @Column(name="born_year")
    val born_year: Int?,

    @Column(name = "height")
    var height: Double?,


    @Lob
    @Type(type="org.hibernate.type.StringType")
    @Column(name="description")
    var description: String?

    ): Serializable {

    @Column(name = "modified_date")
    @LastModifiedDate
    var modifiedDate: Long? = null


    val age: Int?
        get() = if (this.born_year != null) { LocalDateTime.now().year - this.born_year } else null
}