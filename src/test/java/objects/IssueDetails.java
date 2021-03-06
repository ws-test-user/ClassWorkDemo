package objects;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.List;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({
        "url",
        "repository_url",
        "labels_url",
        "comments_url",
        "events_url",
        "html_url",
        "id",
        "number",
        "title",
        "user",
        "labels",
        "state",
        "locked",
        "assignee",
        "assignees",
        "milestone",
        "comments",
        "created_at",
        "updated_at",
        "closed_at",
        "author_association",
        "body",
        "closed_by"
})
public class IssueDetails {

    @JsonProperty("url")
    public String url;
    @JsonProperty("repository_url")
    public String repositoryUrl;
    @JsonProperty("labels_url")
    public String labelsUrl;
    @JsonProperty("comments_url")
    public String commentsUrl;
    @JsonProperty("events_url")
    public String eventsUrl;
    @JsonProperty("html_url")
    public String htmlUrl;
    @JsonProperty("id")
    public Integer id;
    @JsonProperty("number")
    public Integer number;
    @JsonProperty("title")
    public String title;
    @JsonProperty("user")
    public User user;
    @JsonProperty("labels")
    public List<Label> labels = null;
    @JsonProperty("state")
    public String state;
    @JsonProperty("locked")
    public Boolean locked;
    @JsonProperty("assignee")
    public Object assignee;
    @JsonProperty("assignees")
    public List<Object> assignees = null;
    @JsonProperty("milestone")
    public Object milestone;
    @JsonProperty("comments")
    public Integer comments;
    @JsonProperty("created_at")
    public String createdAt;
    @JsonProperty("updated_at")
    public String updatedAt;
    @JsonProperty("closed_at")
    public Object closedAt;
    @JsonProperty("author_association")
    public String authorAssociation;
    @JsonProperty("body")
    public String body;
    @JsonProperty("closed_by")
    public Object closedBy;

}