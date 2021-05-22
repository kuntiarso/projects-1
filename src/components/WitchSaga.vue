<template>
  <div>
    <v-toolbar
      dark
      prominent
      extended
      extension-height="50"
      src="@/assets/witch.jpg"
    >
      <v-app-bar-nav-icon></v-app-bar-nav-icon>
      <v-toolbar-title>WITCH SAGA</v-toolbar-title>
      <v-spacer></v-spacer>

      <v-btn icon>
        <v-icon>mdi-magnify</v-icon>
      </v-btn>
      <v-btn icon>
        <v-icon>mdi-heart</v-icon>
      </v-btn>
      <v-btn icon>
        <v-icon>mdi-dots-vertical</v-icon>
      </v-btn>
    </v-toolbar>

    <br />

    <v-row justify="space-around">
      <v-col cols="12" sm="6">
        <v-card class="ma-4" outlined elevation="8">
          <v-list-item>
            <v-list-item-content>
              <span class="text-subtitle-2">STORY:</span>
              <br />
              <span class="text-body-2">
                Somewhere, there is a village which is controlled by a dark and
                cunning witch.
                <br />
                The witch will kill number of villagers each year by their own
                of decision.
                <br />
                The villagers get furious with the witch and want to get rid of
                her.
                <br />
                But, there's only one way to stop the witch!
                <br />
                Which is to find the average number of villagers killed by the
                witch.
              </span>

              <span class="text-subtitle-2 mt-4">HOW:</span>
              <br />
              <ol class="text-body-2">
                <li>
                  Input <i>age of death</i> and <i>year of death</i> of two
                  villagers to find each of <strong>year of birth</strong>.
                </li>
                <li>
                  Program will count <strong>number of people</strong> were
                  killed in a year based on <strong>year of birth</strong>.
                </li>
                <li>
                  Program will display each of
                  <strong>number of people</strong> were killed from those two
                  villagers.
                </li>
                <li>
                  Each of <strong>number of people</strong> will be added
                  together and then divide by 2 (number of villagers were
                  inputted) to get the <strong>average result</strong>.
                </li>
              </ol>

              <span class="text-subtitle-2 mt-4">CONSTRAINTS:</span>
              <br />
              <ul class="text-body-2">
                <li>
                  Be careful on what number you're put in! If you've inputted
                  <i>age of death</i> with a negative number, the program will
                  return -1, also the witch will continue to kill the villagers!
                </li>
                <li>
                  Another dangerous condition, if program found out that
                  <strong>year of birth</strong> of a villager you're put in is
                  a negative, it will return the same result as point above.
                </li>
              </ul>
            </v-list-item-content>
          </v-list-item>
        </v-card>
      </v-col>
      <v-col cols="12" sm="6">
        <v-card class="ma-4" outlined elevation="8">
          <v-list-item>
            <v-list-item-content>
              <v-row>
                <v-col cols="6">
                  <span class="text-body-2">Villager 1</span>
                  <v-text-field
                    v-model="person1.deathAge"
                    label="Age Of Death"
                    type="number"
                    hide-details
                  ></v-text-field>
                  <v-text-field
                    v-model="person1.deathYear"
                    label="Year Of Death"
                    type="number"
                    hide-details
                  ></v-text-field>
                  <v-text-field
                    v-model="person1.numberOfPeopleWereKilled"
                    label="People Were Killed"
                    hide-details
                    disabled
                  ></v-text-field>
                </v-col>
                <v-col cols="6">
                  <span class="text-body-2">Villager 2</span>
                  <v-text-field
                    v-model="person2.deathAge"
                    label="Age Of Death"
                    type="number"
                    hide-details
                  ></v-text-field>
                  <v-text-field
                    v-model="person2.deathYear"
                    label="Year Of Death"
                    type="number"
                    hide-details
                  ></v-text-field>
                  <v-text-field
                    v-model="person2.numberOfPeopleWereKilled"
                    label="People Were Killed"
                    hide-details
                    disabled
                  ></v-text-field>
                </v-col>
                <v-col cols="12" class="text-center">
                  <v-btn
                    color="orange darken-3"
                    dark
                    @click="findAverageNumber"
                    :loading="isLoadingBtn"
                    :disabled="isLoadingBtn"
                    >play</v-btn
                  >
                </v-col>
              </v-row>
              <v-row v-if="averageValue && description">
                <v-col cols="12">
                  <span class="text-subtitle-2">AVERAGE VALUE:</span>
                  <br />
                  <span class="text-body-2"> {{ averageValue }}</span>
                  <br />
                  <br />
                  <span class="text-subtitle-2">DESCRIPTION:</span>
                  <br />
                  <span class="text-body-2"> {{ description }}</span>
                </v-col>
                <v-col cols="12" class="text-center">
                  <span
                    v-if="averageValue && averageValue >= 0"
                    class="text-subtitle-2"
                    >CONGRATULATION!</span
                  >
                  <span v-else class="text-subtitle-2">OH NOOO!</span>
                </v-col>
              </v-row>
            </v-list-item-content>
          </v-list-item>
        </v-card>
      </v-col>
    </v-row>
  </div>
</template>

<script>
import axios from "axios";

const URL = "https://polar-fjord-81408.herokuapp.com/stop-the-witch";

export default {
  data: () => ({
    person1: {
      birthYear: null,
      deathAge: null,
      deathYear: null,
      numberOfPeopleWereKilled: null,
    },
    person2: {
      birthYear: null,
      deathAge: null,
      deathYear: null,
      numberOfPeopleWereKilled: null,
    },

    isLoadingBtn: false,
    averageValue: null,
    description: String(),
  }),
  methods: {
    async findAverageNumber() {
      this.isLoadingBtn = true;

      try {
        let res = await axios.get(URL, {
          params: {
            deathAgePerson1: this.person1.deathAge ? this.person1.deathAge : 0,
            deathYearPerson1: this.person1.deathYear
              ? this.person1.deathYear
              : 0,
            deathAgePerson2: this.person2.deathAge ? this.person2.deathAge : 0,
            deathYearPerson2: this.person2.deathYear
              ? this.person2.deathYear
              : 0,
          },
        });
        this.person1 = res.data.person1;
        this.person2 = res.data.person2;
        this.description = res.data.description;
        this.averageValue = res.data.result;
        this.isLoadingBtn = false;
      } catch (e) {
        console.debug("error", e);
        this.isLoadingBtn = false;
      }
    },

    resetData() {
      this.person1 = {
        deathAge1: null,
        deathYear1: null,
        birthYear1: null,
      };
      this.person2 = {
        deathAge2: null,
        deathYear2: null,
        birthYear2: null,
      };
      this.description = String();
      this.averageValue = null;
    },
  },
};
</script>
