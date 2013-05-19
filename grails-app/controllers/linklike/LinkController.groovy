package linklike

class LinkController {

    def index() { 
        def links = Link.findAll()
        [ links: links ]
    }

    def create() {
        def link = new Link(title: params.title, url: params.url)
        link.save()
        redirect(action: "index")
    }

    def like() {
        def link = Link.findById(params.id)
        link.numLike += 1
        redirect(action: "index")
    }
}
