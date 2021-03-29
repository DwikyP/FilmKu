package com.dp13.filmku.utils

import com.dp13.filmku.data.source.local.entity.FavoriteMovieEntity
import com.dp13.filmku.data.source.local.entity.FavoriteTvShowEntity
import com.dp13.filmku.data.source.local.entity.MovieEntity
import com.dp13.filmku.data.source.local.entity.TvShowEntity
import com.dp13.filmku.data.source.remote.response.MovieResponse
import com.dp13.filmku.data.source.remote.response.TvShowResponse

object DataDummy {
    fun generatesDummyMovies(): List<MovieEntity> {
        val movies = ArrayList<MovieEntity>()

        movies.add(
            MovieEntity(
                "m1",
                "https://m.media-amazon.com/images/M/MV5BMDVkMDRkMzItN2EyYS00ZTI5LTljYzgtNzRmZDQ0OTQ3M2VjXkEyXkFqcGdeQXVyODk4OTc3MTY@._V1_.jpg",
                "The White Tiger",
                "2021",
                "Crime, Drama",
                "2h 5min",
                "7.2",
                "An ambitious Indian driver uses his wit and cunning to escape from poverty and rise to the top. An epic journey based on the New York Times bestseller.",
                "Adarsh Gourav, Rajkummar Rao, PriyankChopra",
                "Ramin Bahrani",
                "Ramin Bahrani, Aravind Adiga",
                "22 January 2021"
            )
        )

        movies.add(
            MovieEntity(
                "m2",
                "https://m.media-amazon.com/images/M/MV5BZGE1MDg5M2MtNTkyZS00MTY5LTg1YzUtZTlhZmM1Y2EwNmFmXkEyXkFqcGdeQXVyNjA3OTI0MDc@._V1_.jpg",
                "Soul",
                "2020",
                "Animation, Adventure, Comedy",
                "1h 40min",
                "8.1",
                "After landing the gig of a lifetime, a New York jazz pianist suddenly finds himself trapped in a strange land between Earth and the afterlife. .",
                "Jamie Foxx, Tina Fey, Graham Norton",
                "Pete Docter, Kemp Powers",
                "Pete Docter, Mike Jones",
                "25 December 2020"
            )
        )

        movies.add(
            MovieEntity(
                "m3",
                "https://m.media-amazon.com/images/M/MV5BYTlhNzJjYzYtNGU3My00ZDI5LTgzZDUtYzllYjU1ZmU0YTgwXkEyXkFqcGdeQXVyMjQwMDg0Ng@@._V1_.jpg",
                "Wonder Woman 1984",
                "2020",
                "Action, Adventure, Fantasy",
                "2h 31min",
                "5.4",
                "Diana must contend with a work colleague and businessman, whose desire for extreme wealth sends the world down a path of destruction, after an ancient artifact that grants wishes goes missing. ",
                "Gal Gadot, Chris Pine, Kristen Wiig",
                "Patty Jenkins",
                "Patty Jenkins, Geoff Johns",
                "25 December 2020"
            )
        )

        movies.add(
            MovieEntity(
                "m4",
                "https://m.media-amazon.com/images/M/MV5BZmE0MGJhNmYtOWNjYi00Njc5LWE2YjEtMWMxZTVmODUwMmMxXkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_.jpg",
                "The Lighthouse",
                "2020",
                "Drama, Fantasy, Horror",
                "1h 49min",
                "7.2",
                "Two lighthouse keepers try to maintain their sanity while living on a remote and mysterious New England island in the 1890s.",
                "Robert Pattinson, Willem Dafoe, Valeriia Karaman",
                "Robert Eggers",
                "Robert Eggers, Max Eggers",
                "1 November 2019"
            )
        )

        movies.add(
            MovieEntity(
                "m5",
                "https://m.media-amazon.com/images/M/MV5BYzg0NGM2NjAtNmIxOC00MDJmLTg5ZmYtYzM0MTE4NWE2NzlhXkEyXkFqcGdeQXVyMTA4NjE0NjEy._V1_.jpg",
                "Tenet",
                "2020",
                "Action, Sci-Fi, Thriller",
                "2h 30min",
                "7.5",
                "Armed with only one word, Tenet, and fighting for the survival of the entire world, a Protagonist journeys through a twilight world of international espionage on a mission that will unfold in something beyond real time.",
                "John David Washington, Robert Pattinson, Elizabeth Debicki",
                "Christopher Nolan",
                "Christopher Nolan",
                "3 September 2020"
            )
        )
        return movies
    }

    fun generateDummyTvShows(): List<TvShowEntity> {
        val tvshows = ArrayList<TvShowEntity>()

        tvshows.add(
            TvShowEntity(
                "tv1",
                "https://m.media-amazon.com/images/M/MV5BMTY5ODk1NzUyMl5BMl5BanBnXkFtZTgwMjUyNzEyMTE@._V1_.jpg",
                "Attack on Titan",
                "2013-",
                "Animation, Action, Adventure",
                "24min",
                "8.9",
                "After his hometown is destroyed and his mother is killed, young Eren Jaeger vows to cleanse the earth of the giant humanoid Titans that have brought humanity to the brink of extinction.",
                "Yûki Kaji, Marina Inoue, Yui Ishikawa",
                "Hajime Isayama",
                "ONGOING",
                79
            )
        )

        tvshows.add(
            TvShowEntity(
                "tv2",
                "https://m.media-amazon.com/images/M/MV5BNGEyOGJiNWEtMTgwMi00ODU4LTlkMjItZWI4NjFmMzgxZGY2XkEyXkFqcGdeQXVyNjcyNjcyMzQ@._V1_.jpg",
                "The Boys",
                "2019-",
                "Action, Comedy, Crime",
                "1h",
                "8.7",
                "A group of vigilantes set out to take down corrupt superheroes who abuse their superpowers.",
                "Karl Urban, Jack Quaid, Antony Starr",
                "Eric Kripke",
                "ONGOING",
                19
            )
        )

        tvshows.add(
            TvShowEntity(
                "tv3",
                "https://m.media-amazon.com/images/M/MV5BMjEzMDAxOTUyMV5BMl5BanBnXkFtZTgwNzAxMzYzOTE@._V1_.jpg",
                "Stranger Things",
                "2016-",
                "Drama, Fantasy, Horror",
                "51min",
                "8.7",
                "When a young boy disappears, his mother, a police chief and his friends must confront terrifying supernatural forces in order to get him back.",
                "Millie Bobby Brown, Finn Wolfhard, Winona Ryder",
                "Matt Duffer, Ross Duffer",
                "ONGOING",
                34
            )
        )

        tvshows.add(
            TvShowEntity(
                "tv4",
                "https://m.media-amazon.com/images/M/MV5BODcwOTg2MDE3NF5BMl5BanBnXkFtZTgwNTUyNTY1NjM@._V1_.jpg",
                "Daredevil",
                "2015-2018",
                "Action, Crime, Drama",
                "54min",
                "8.6",
                "A blind lawyer by day, vigilante by night. Matt Murdock fights the crime of New York as Daredevil.",
                "Charlie Cox, Vincent D'Onofrio, Deborah Ann Woll",
                "Drew Goddard",
                "COMPLETED",
                39
            )
        )

        tvshows.add(
            TvShowEntity(
                "tv5",
                "https://m.media-amazon.com/images/M/MV5BYjJiZmE5ZDgtYWUxZi00MWI1LTg2MmEtZmUwZGE2YzRkNTE5XkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_.jpg",
                "WandaVision",
                "2021",
                "Action, Comedy, Drama",
                "29-41min",
                "8.0",
                "Blends the style of classic sitcoms with the MCU in which Wanda Maximoff and Vision -two super-powered beings living their ideal suburban lives-begin to suspect that everything is not as it seems.",
                "Elizabeth Olsen, Paul Bettany, Teyonah Parris",
                "Jac Schaeffer",
                "ONGOING",
                9
            )
        )

        return tvshows
    }

    fun generatesDummyFavoriteMovies(): List<FavoriteMovieEntity> {
        val favMovies = ArrayList<FavoriteMovieEntity>()

        favMovies.add(
            FavoriteMovieEntity(
                "m1",
                "https://m.media-amazon.com/images/M/MV5BMDVkMDRkMzItN2EyYS00ZTI5LTljYzgtNzRmZDQ0OTQ3M2VjXkEyXkFqcGdeQXVyODk4OTc3MTY@._V1_.jpg",
                "The White Tiger",
                "2021",
                "An ambitious Indian driver uses his wit and cunning to escape from poverty and rise to the top. An epic journey based on the New York Times bestseller.",
            )
        )

        favMovies.add(
            FavoriteMovieEntity(
                "m2",
                "https://m.media-amazon.com/images/M/MV5BZGE1MDg5M2MtNTkyZS00MTY5LTg1YzUtZTlhZmM1Y2EwNmFmXkEyXkFqcGdeQXVyNjA3OTI0MDc@._V1_.jpg",
                "Soul",
                "2020",
                "After landing the gig of a lifetime, a New York jazz pianist suddenly finds himself trapped in a strange land between Earth and the afterlife. .",
            )
        )

        favMovies.add(
            FavoriteMovieEntity(
                "m3",
                "https://m.media-amazon.com/images/M/MV5BYTlhNzJjYzYtNGU3My00ZDI5LTgzZDUtYzllYjU1ZmU0YTgwXkEyXkFqcGdeQXVyMjQwMDg0Ng@@._V1_.jpg",
                "Wonder Woman 1984",
                "2020",
                "Diana must contend with a work colleague and businessman, whose desire for extreme wealth sends the world down a path of destruction, after an ancient artifact that grants wishes goes missing. "
            )
        )

        favMovies.add(
            FavoriteMovieEntity(
                "m4",
                "https://m.media-amazon.com/images/M/MV5BZmE0MGJhNmYtOWNjYi00Njc5LWE2YjEtMWMxZTVmODUwMmMxXkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_.jpg",
                "The Lighthouse",
                "2020",
                "Two lighthouse keepers try to maintain their sanity while living on a remote and mysterious New England island in the 1890s.",
            )
        )

        favMovies.add(
            FavoriteMovieEntity(
                "m5",
                "https://m.media-amazon.com/images/M/MV5BYzg0NGM2NjAtNmIxOC00MDJmLTg5ZmYtYzM0MTE4NWE2NzlhXkEyXkFqcGdeQXVyMTA4NjE0NjEy._V1_.jpg",
                "Tenet",
                "2020",
                "Armed with only one word, Tenet, and fighting for the survival of the entire world, a Protagonist journeys through a twilight world of international espionage on a mission that will unfold in something beyond real time.",
            )
        )
        return favMovies
    }

    fun generateDummyFavoriteTvShows(): List<FavoriteTvShowEntity> {
        val favTvshows = ArrayList<FavoriteTvShowEntity>()

        favTvshows.add(
            FavoriteTvShowEntity(
                "tv1",
                "https://m.media-amazon.com/images/M/MV5BMTY5ODk1NzUyMl5BMl5BanBnXkFtZTgwMjUyNzEyMTE@._V1_.jpg",
                "Attack on Titan",
                "2013-",
                "After his hometown is destroyed and his mother is killed, young Eren Jaeger vows to cleanse the earth of the giant humanoid Titans that have brought humanity to the brink of extinction.",
                "ONGOING",
                79
            )
        )

        favTvshows.add(
            FavoriteTvShowEntity(
                "tv2",
                "https://m.media-amazon.com/images/M/MV5BNGEyOGJiNWEtMTgwMi00ODU4LTlkMjItZWI4NjFmMzgxZGY2XkEyXkFqcGdeQXVyNjcyNjcyMzQ@._V1_.jpg",
                "The Boys",
                "2019-",
                "A group of vigilantes set out to take down corrupt superheroes who abuse their superpowers.",
                "ONGOING",
                19
            )
        )

        favTvshows.add(
            FavoriteTvShowEntity(
                "tv3",
                "https://m.media-amazon.com/images/M/MV5BMjEzMDAxOTUyMV5BMl5BanBnXkFtZTgwNzAxMzYzOTE@._V1_.jpg",
                "Stranger Things",
                "2016-",
                "When a young boy disappears, his mother, a police chief and his friends must confront terrifying supernatural forces in order to get him back.",
                "ONGOING",
                34
            )
        )

        favTvshows.add(
            FavoriteTvShowEntity(
                "tv4",
                "https://m.media-amazon.com/images/M/MV5BODcwOTg2MDE3NF5BMl5BanBnXkFtZTgwNTUyNTY1NjM@._V1_.jpg",
                "Daredevil",
                "2015-2018",
                "A blind lawyer by day, vigilante by night. Matt Murdock fights the crime of New York as Daredevil.",
                "COMPLETED",
                39
            )
        )

        favTvshows.add(
            FavoriteTvShowEntity(
                "tv5",
                "https://m.media-amazon.com/images/M/MV5BYjJiZmE5ZDgtYWUxZi00MWI1LTg2MmEtZmUwZGE2YzRkNTE5XkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_.jpg",
                "WandaVision",
                "2021",
                "Blends the style of classic sitcoms with the MCU in which Wanda Maximoff and Vision -two super-powered beings living their ideal suburban lives-begin to suspect that everything is not as it seems.",
                "ONGOING",
                9
            )
        )

        return favTvshows
    }

    fun generateRemoteDummyMovies(): List<MovieResponse> {
        val movies = ArrayList<MovieResponse>()

        movies.add(
            MovieResponse(
                "m1",
                "https://m.media-amazon.com/images/M/MV5BMDVkMDRkMzItN2EyYS00ZTI5LTljYzgtNzRmZDQ0OTQ3M2VjXkEyXkFqcGdeQXVyODk4OTc3MTY@._V1_.jpg",
                "The White Tiger",
                "2021",
                "Crime, Drama",
                "2h 5min",
                "7.2",
                "An ambitious Indian driver uses his wit and cunning to escape from poverty and rise to the top. An epic journey based on the New York Times bestseller.",
                "Adarsh Gourav, Rajkummar Rao, PriyankChopra",
                "Ramin Bahrani",
                "Ramin Bahrani, Aravind Adiga",
                "22 January 2021"
            )
        )

        movies.add(
            MovieResponse(
                "m2",
                "https://m.media-amazon.com/images/M/MV5BZGE1MDg5M2MtNTkyZS00MTY5LTg1YzUtZTlhZmM1Y2EwNmFmXkEyXkFqcGdeQXVyNjA3OTI0MDc@._V1_.jpg",
                "Soul",
                "2020",
                "Animation, Adventure, Comedy",
                "1h 40min",
                "8.1",
                "After landing the gig of a lifetime, a New York jazz pianist suddenly finds himself trapped in a strange land between Earth and the afterlife. .",
                "Jamie Foxx, Tina Fey, Graham Norton",
                "Pete Docter, Kemp Powers",
                "Pete Docter, Mike Jones",
                "25 December 2020"
            )
        )

        movies.add(
            MovieResponse(
                "m3",
                "https://m.media-amazon.com/images/M/MV5BYTlhNzJjYzYtNGU3My00ZDI5LTgzZDUtYzllYjU1ZmU0YTgwXkEyXkFqcGdeQXVyMjQwMDg0Ng@@._V1_.jpg",
                "Wonder Woman 1984",
                "2020",
                "Action, Adventure, Fantasy",
                "2h 31min",
                "5.4",
                "Diana must contend with a work colleague and businessman, whose desire for extreme wealth sends the world down a path of destruction, after an ancient artifact that grants wishes goes missing. ",
                "Gal Gadot, Chris Pine, Kristen Wiig",
                "Patty Jenkins",
                "Patty Jenkins, Geoff Johns",
                "25 December 2020"
            )
        )

        movies.add(
            MovieResponse(
                "m4",
                "https://m.media-amazon.com/images/M/MV5BZmE0MGJhNmYtOWNjYi00Njc5LWE2YjEtMWMxZTVmODUwMmMxXkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_.jpg",
                "The Lighthouse",
                "2020",
                "Drama, Fantasy, Horror",
                "1h 49min",
                "7.2",
                "Two lighthouse keepers try to maintain their sanity while living on a remote and mysterious New England island in the 1890s.",
                "Robert Pattinson, Willem Dafoe, Valeriia Karaman",
                "Robert Eggers",
                "Robert Eggers, Max Eggers",
                "1 November 2019"
            )
        )

        movies.add(
            MovieResponse(
                "m5",
                "https://m.media-amazon.com/images/M/MV5BYzg0NGM2NjAtNmIxOC00MDJmLTg5ZmYtYzM0MTE4NWE2NzlhXkEyXkFqcGdeQXVyMTA4NjE0NjEy._V1_.jpg",
                "Tenet",
                "2020",
                "Action, Sci-Fi, Thriller",
                "2h 30min",
                "7.5",
                "Armed with only one word, Tenet, and fighting for the survival of the entire world, a Protagonist journeys through a twilight world of international espionage on a mission that will unfold in something beyond real time.",
                "John David Washington, Robert Pattinson, Elizabeth Debicki",
                "Christopher Nolan",
                "Christopher Nolan",
                "3 September 2020"
            )
        )
        return movies
    }

    fun generateRemoteDummyTvShows(): List<TvShowResponse>{
        val tvshows = ArrayList<TvShowResponse>()

        tvshows.add(TvShowResponse(
            "tv1",
            "https://m.media-amazon.com/images/M/MV5BMTY5ODk1NzUyMl5BMl5BanBnXkFtZTgwMjUyNzEyMTE@._V1_.jpg",
            "Attack on Titan",
            "2013-",
            "Animation, Action, Adventure",
            "24min",
            "8.9",
            "After his hometown is destroyed and his mother is killed, young Eren Jaeger vows to cleanse the earth of the giant humanoid Titans that have brought humanity to the brink of extinction.",
            "Yûki Kaji, Marina Inoue, Yui Ishikawa",
            "Hajime Isayama",
            "ONGOING",
            79
        ))

        tvshows.add(TvShowResponse(
            "tv2",
            "https://m.media-amazon.com/images/M/MV5BNGEyOGJiNWEtMTgwMi00ODU4LTlkMjItZWI4NjFmMzgxZGY2XkEyXkFqcGdeQXVyNjcyNjcyMzQ@._V1_.jpg",
            "The Boys",
            "2019-",
            "Action, Comedy, Crime",
            "1h",
            "8.7",
            "A group of vigilantes set out to take down corrupt superheroes who abuse their superpowers.",
            "Karl Urban, Jack Quaid, Antony Starr",
            "Eric Kripke",
            "ONGOING",
            19
        ))

        tvshows.add(TvShowResponse(
            "tv3",
            "https://m.media-amazon.com/images/M/MV5BMjEzMDAxOTUyMV5BMl5BanBnXkFtZTgwNzAxMzYzOTE@._V1_.jpg",
            "Stranger Things",
            "2016-",
            "Drama, Fantasy, Horror",
            "51min",
            "8.7",
            "When a young boy disappears, his mother, a police chief and his friends must confront terrifying supernatural forces in order to get him back.",
            "Millie Bobby Brown, Finn Wolfhard, Winona Ryder",
            "Matt Duffer, Ross Duffer",
            "ONGOING",
            34
        ))

        tvshows.add(TvShowResponse(
            "tv4",
            "https://m.media-amazon.com/images/M/MV5BODcwOTg2MDE3NF5BMl5BanBnXkFtZTgwNTUyNTY1NjM@._V1_.jpg",
            "Daredevil",
            "2015-2018",
            "Action, Crime, Drama",
            "54min",
            "8.6",
            "A blind lawyer by day, vigilante by night. Matt Murdock fights the crime of New York as Daredevil.",
            "Charlie Cox, Vincent D'Onofrio, Deborah Ann Woll",
            "Drew Goddard",
            "COMPLETED",
            39
        ))

        tvshows.add(TvShowResponse(
            "tv5",
            "https://m.media-amazon.com/images/M/MV5BYjJiZmE5ZDgtYWUxZi00MWI1LTg2MmEtZmUwZGE2YzRkNTE5XkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_.jpg",
            "WandaVision",
            "2021",
            "Action, Comedy, Drama",
            "29-41min",
            "8.0",
            "Blends the style of classic sitcoms with the MCU in which Wanda Maximoff and Vision -two super-powered beings living their ideal suburban lives-begin to suspect that everything is not as it seems.",
            "Elizabeth Olsen, Paul Bettany, Teyonah Parris",
            "Jac Schaeffer",
            "ONGOING",
            9
        ))

        return tvshows
    }
}